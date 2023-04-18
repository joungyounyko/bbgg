package com.board.model.dao;

import static com.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.board.model.vo.Board;


public class BoardDao {

	private Properties prop = new Properties();
	
	
	
	
	public ArrayList<Board> selectThumbnailList(Connection conn){
		
		ArrayList<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThumbnailList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {

				Board b = new Board();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setTitle(rset.getString("TITLE"));
				b.setNickName(rset.getString("NICKNAME"));
				b.setWriteDate(rset.getDate("WRITEDATE"));
				
				list.add(b);

				System.out.println("sql :: " + sql);
				System.out.println("rset :: " + rset); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}
	
	
	
	

	
	
	
	
	
	
	
}
