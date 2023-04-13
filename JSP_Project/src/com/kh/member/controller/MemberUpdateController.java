package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) post방식 - 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2 요청 시 전달한 값 뽑기
		// name phone email address interest + USERID 같이 담아서 보내기 .. 
		
		String usetName = request.getParameter("userName");
		String phone= request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr= request.getParameterValues("interest"); // null rkqtdl 
		String userId =request.getParameter("userId");
		
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		// 3 vo객체에 담기
		Member m = new Member();
		m.setUserName(usetName);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		m.setInterest(interest);
		m.setUserId(userId);
		
		
		// 4 서비스로 토스
		Member updateMem = new MemberService().updateMember(m);
		
		// 5 결과 화면 
		
		if(updateMem != null) {
			
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "정보수정 성공");
			
			// request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
			
			// sendRedirect방식으로 바꿔보기 ..
			// .jsp/myPage.me 
			
			response.sendRedirect(request.getContextPath()+"/myPage.me");
			
			
			
			
			
			
			
			
			
			
			
			
		}else {
			request.setAttribute("errorMsg", "수정실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}
		
		
		
		
		
		
		
		
		
	}
		
		
	

}
