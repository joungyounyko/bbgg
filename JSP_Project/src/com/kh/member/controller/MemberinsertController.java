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
 * Servlet implementation class MemberinsertController
 */
@WebServlet("/insert.me")
public class MemberinsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberinsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// POST
	// 1) 인코딩 설정 
		
		request.setCharacterEncoding("UTF-8");
	
	// 2) request객체로부터 요청 시 전달 값 뽑기
		
		String userId =
		request.getParameter("userId"); // 테이블 어떻게 설정했지? "필수입력"
		String userPwd = request.getParameter("userPwd"); // "필수입력"
		String userName = request.getParameter("userName"); // "필수입력"
		String phone = request.getParameter("phone"); // 빈문자열이 들어갈 수 있음
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		String[] interestArr = request.getParameterValues("interest"); // ["여행", "빵"] null
		
		// 자취, 여행 .. 으로 바꿔서
		// String.join("구분자",배열명); 
		
		
		String interest = "";// null 이면?
		if(interestArr != null) { // null아니면
			interest = 
			String.join(",",interestArr);
		}

		
	
		// 3) Member 객체에 담기(setter메소드로 해보자
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setUserName(userName);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		m.setInterest(interest);
	
	
		// 4) 요청처리(Service단으로 토스)
		int result = 
				new MemberService().insertMember(m);
		// 5 처리결과를 가지고 사용자가 보게 될 응답화면 지정
		
		if(result>0) { // 성공 /jsp index.jsp -> url재요청방식 sendRedirect
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공");
			response.sendRedirect(request.getContextPath());
			
		}else {
			
			request.setAttribute("errorMsg", "가입실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
