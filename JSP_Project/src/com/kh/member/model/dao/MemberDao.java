package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String file =
		MemberDao.class.getResource("/sql/member/memver-mapper.xml").getPath();
		
		
	//	System.out.println(file);
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// SELECT문 -> ResultSet객체 (unique key 제약조건에 의해 한 행만 조회됨 ) Member
		
		// 필요한 변수 세팅
		 
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		
		
		
		
		
		try {
			// pstmt 객체 생성
			pstmt =	conn.prepareStatement(sql);
		
		
			// 위치홀더 채우기
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
		
			// 쿼리문 실행 후 결과 받기
			// 쿼리문 실행 메소드
			// pstmt.executeQuety(); -> ResultSet : SELECT
			// pstmt.executeUpdate(); -> int / 0  : INSERT / UPDATE / DELETE
		
			rset = pstmt.executeQuery();
			
			// rset 으로 부터 각각의 컬럼의 값을 뽑아서 Member객체에 담는다
			// 조회결과가 한 행 일때 -> if(rset.next())
			// 조회결과가 여러 행 일때 -> while(rset.next())
			
			if(rset.next()) {
				
				// 각 컬럼의 값 뽑기
				// rset.getInt/ rset.getString / rset.getDate(뽑아올 컬럼명 또는 컬럼의 순번)
				
				m =new Member(rset.getInt("USER_NO"),
							rset.getString("USER_ID"),
							rset.getString("USER_PWD"),
							rset.getString("USER_NAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getString("INTEREST"),
							rset.getDate("ENROLL_DATE"),
							rset.getDate("MODIFY_DATE"),
							rset.getString("STATUS"));
				
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		
		
		return m;
		
		
		
		
	}
	
	
	public int insertMember(Connection conn, Member m) {
		
		
		//INSERT문
		int result= 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
		
		
		// pstmt 객체 생성 (sql미리전달) 
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 빵꾸 메꾸기 
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			// SQL문 실행 및 결과 받기
			// insert /update / delete = pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
		
	}
	
	public int updateMember(Connection conn, Member m ) {
		
		
		//update 처리된 행의 개수
		// 필요한 변수 
			int result= 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("updateMember");
	
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getUserName());
				pstmt.setString(2, m.getPhone());
				pstmt.setString(3, m.getEmail());
				pstmt.setString(4, m.getAddress());
				pstmt.setString(5, m.getInterest());
				
				pstmt.setString(6, m.getUserId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
				
			}
			return result;
		
		
	}
	
	public Member selectMember(Connection conn, String userId) {
		
		// select문 member
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();

			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("PHONE"),
						rset.getString("EMAIL"),
						rset.getString("ADDRESS"),
						rset.getString("INTEREST"),
						rset.getDate("ENROLL_DATE"),
						rset.getDate("MODIFY_DATE"),
						rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return m;
		
		
	}
	
	
	public int updatePwdMember(Connection conn, int userNo, String userPwd, String updatePwd) {
		
		int result= 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		
		
		
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setInt(2, userNo);
			pstmt.setString(3, userPwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
