package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberUpdateControlle
 */
@WebServlet("/updatePwd.me")
public class MemberUpdateControlle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateControlle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	request.setCharacterEncoding("UTF-8");
	
	// 값뽑기
	
	int userNo = Integer.parseInt(request.getParameter("userNO"));
	
	String userPwd = request.getParameter("userPwd");
	String updatePwd = request.getParameter("updatePwd");
	

	
	// 	UPDATE MEMBER SET USER_PWD = updatePwd  WHERE USER_PWD = userpwd AND USER_NO = userNO
	
	
	// 3) vo객체에 담아서 가공 - 그냥 넘겨보자
	
	
	
	// 4 Service 단으로 토스
	
	
	new MemberService().updatePwdMember(userNo, userPwd, updatePwd);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
