<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.member.model.vo.Member" %>
    <%
    	Member loginUser =(Member)session.getAttribute("loginUser");
    	// 로그인 전 : loginUser == null
    	// 로그인 후 : loginUser == 로그인에 성공한 회원의 정보가 담겨있음
    	
    	// 메시지 뽑기
		String alertMsg = (String)session.getAttribute("alertMsg");

    	// 요청 전 null
    	// 요청 후 메시지 문구 
    	
    	String contextPath 
    	= request.getContextPath();
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>

	.login-area, #user-info{
	
		float : right;
	
	}
	
	#user-info a{
	text-decoration : none;
	color : gray;
	font-size : 12px;
	}
	
	
	
	
	.nav-area{
		background-color: rgb(198, 199, 199);
	}
	.menu{
		display: table-cell;
		width: 150px;
		height: 50px;
	}
	.menu a{
		text-decoration: none;
		color: aliceblue;
		font-size: 20px;
		font-weight: bold;
		display: block;
		width:  100%;
		height: 100%;
		line-height: 50px;
	}
	.menu a:hover{
		background-color: darkgreen;
	}


</style>
</head>
<body>

	<script>
	// script태그 안에서도 스크립틀릿 같은 jsp 요소 사용 가능

	
	var msg= '<%= alertMsg %>'; //  null / 메시지문구  자바문자열로 바꿔야됨
	
	if(msg != 'null'){
		alert(msg);
		
		
		// session에 들어있는 alertMsg 키값에 대한 벨류를 지워줘야함
		// menubar.jsp가 로딩될때마다 alert이 계속 쓰니까
		// xx.removeAttribute("키값");
		<% session.removeAttribute("alertMsg"); %>
		
		
		
	}
	
	
	
	
	
	
	
	</script>
	<h1 align="center">개발하여 건물주 되기</h1>


	<div class="login-area">
	<!-- 
		form 태그 안에 있는 제출버튼 클릭시 form태그가 가지고 있는 속성 중
		action에 작성된 url로 요청
		즉 Controller(Servlet)를 호출한다고 생각하면됨

		Servlet요청 같은 경우 반드시 그 요청값이 현재 웹 어플리케이션의 
		context Path == context Root 뒤에 붙은 경로
		형식으로 작성해야함
		-> http://localhost:8001/jsp/test1.do(서블릿매핑값)

		* 경로 지정박싱
		절대경로방식(/) : Cotext Root/ 요청할 url
						/ 로 시작하는 경우
						localhost:8001 뒤에 action 속성에 작성한 값이 붙으면서 요청


		상대경로방식 test1.do 요청할 url 문구로 시작하는 경우
				현재 이 페이지가 보여질때url 경로 중에서 
				마지막 / 로부터 뒤에 action 속성에 적은 값이 붙으면서 요청
	-->
	<% if(loginUser == null){ %>
	<!-- 사용자가 로그인 전 보게 될 화면 -->
	<!-- <form action=contextPath"/jsp/login.me" method="post">  -->
	<form action="<%= contextPath %>/login.me" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userId" required></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="userPwd" required></td>
			</tr>
		
			<tr>
				<th colspan="2">
					<button type="submit" class="btn btn-light">로그인</button>
					<button type="button" onclick="enrollPage();" class="btn btn-light">회원가입</button>

				</th>
			</tr>

		</table>
	
	</form>
	<script>
		function enrollPage(){
			// 페이지이동
			location.href = '<%= contextPath %>/views/member/memberEnrollForm.jsp';
			// 웹 어플리케이션의 디렉토리 구조가 url 노출 - 보안에 취약
			
			// 단순한 정적인 페이지 요청이라 하더라도 Servlet을 거쳐서 화면을 띄워줄 예정
			// url에 서블릿 매핑값만 노출
			location.href='<%=contextPath %>/enrollForm.me'
			
			
		}
		</script>
	
	
	
	
	
	
	<% }else{ %>
	<!-- 사용자가 로그인 후 보게 될 화면 -->
	
	<div id="user-info">
		<b><%= loginUser.getUserName() %></b>님 환영합니다 <br>
		<div align="center">
			<a href="<%= contextPath %>/myPage.me">마이페이지</a>
			<a href="<%= contextPath %>/logout.me">로그아웃</a>

			</div>
		</div>
		<%} %>
		
		
		
	</div>
		<br clear="both">

	<div class="nav-area" align="center">
		<div class="menu"><a href="#">홈</a></div>
		<div class="menu"><a href="#">공지사항</a></div>
		<div class="menu"><a href="#">일반</a></div>
		<div class="menu"><a href="#">사진</a></div>
	</div>




</body>
</html>