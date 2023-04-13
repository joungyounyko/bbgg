package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyPagecontroller
 */
@WebServlet("/myPage.me")
public class MyPagecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagecontroller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Forwading
		// 2. Redirect
	
	
	
	//RequestDispatcher view = request.getRequestDispatcher("views/member/myPage.jsp");
		//	view.forward(request, response);
	
	// 로그아웃 후 url 직접요청했더니 마이페이지가 뜸 그럼안되니까 위에방법은 안됨
		// 접속자의 정보 - >   session  브라우저 하나당 하나만 나옴
		// 로그인 전 : loginUser 키값에 해당 하는 벨류가 null값
		// 로그인 후 : loginUser 키값에 해당하는 벨류가 Member주소값 -> 포워딩
		
		
		HttpSession session = request.getSession();
		//session.getAttribute();
		
		
		// 로그인햇니 안햇니 
		
		
		if(session.getAttribute("loginUser")==null) { // 로그인노노
			
			session.setAttribute("alertMsg", "로그인해");
			response.sendRedirect(request.getContextPath());
			
			
		}else {
			
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage.jsp");
			view.forward(request, response);
		}
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
