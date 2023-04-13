package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection () {
		Connection conn = null;
		
		Properties prop = new Properties();
		
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();

		try {
			prop.load(new FileInputStream(fileName));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 2. Connection 객체를 트랜잭션처리를 해주는 메소드 
	// 2-1) 전달받은 Connection 객체를 가지고 COMMIT 시켜주는 메소드 
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2-2) 전달받은 Connection 객체를 가지고 ROLLBACK 시켜주는 메소드 
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. JDBC용 객체를 반납시켜주는 메소드 (각 객체별로)
	// 3-1) Connection 객체를 전달받아서 반납시켜주는 메소드 
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3-2) Statement 객체를 전달받아서 반납시켜주는 메소드 (오버로딩)
	// => 다형성 적용으로 인해 PreparedStatement 객체도 Statement 타입으로 받을 수 있음 
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3-3) ResultSet 객체를 전달받아서 반납시켜주는 메소드 (오버로딩)
	// 
	
	public static void close(ResultSet rset) {
		try {
			if(rset!=null && !rset.isClosed()) {
				rset.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
