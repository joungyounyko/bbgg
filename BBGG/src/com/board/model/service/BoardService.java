package com.board.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;


import java.sql.Connection;
import java.util.ArrayList;

import com.board.model.dao.BoardDao;
import com.board.model.vo.Board;

public class BoardService {

	
	
	
	
	
	
	
	public ArrayList<Board> selectThumbnailList() {
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectThumbnailList(conn);
		
		close(conn);
		
		return list;
	}
		

	

}
