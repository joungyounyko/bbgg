<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.board.model.vo.Board" %>
    <% 
    String contextPath = request.getContextPath();
    ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style>

    #wrap{
        width: 1200px;
    }
    #wrap-left{
        width: 250px;
        float: left;
    }
    #wrap-right{
        float: left;
        background-color: rgb(185, 137, 74);
        width: 950px;
        margin-top:120px;
        padding: 20px;
        height: 800px;
    }

	#content{
		width :900px;
	    height : 100%;
	
	    float: center;
		
	}
	
	#content1>div{
          height: 450px;
          float: left;
      }
	  #content2>div, #content3>div{
          height: 250px;
          float: left;
      }

      #content_1 { 
		width : 900px;
	  }



	    .list-area{
        text-align: center;

    }
    	img{
		width: 150px;
		height: 100px;
		padding: 10px;
	}
		.thumbnail{ 

		display: inline-block;
		margin: 6px;
	}
	    .list-area{
        text-align: center;

    }
    	.thumbnail:hover{
		cursor: pointer;
		background-color:cadetblue;
	}
	.inline{
        display: inline;
    }
    .inline-block{
        display: inline-block;
    }
    .block{
        display: block;
    }
	.display-test{
		width: 447px; 
    }

</style>
</head>
<body>
    <div id="wrap">
        <div id="wrap-left">
            <%@ include file="boardBar.jsp" %>
        </div>
        <div id="wrap-right">


			<div id="content">
			<a href="<%=contextPath%>/boardMain.bm"></a>
				<div id="content_1"><h3>커뮤니티</h3>
				
					<br>
						<div class="list-area">
						<h2 align="center">리뷰게시판</h2>
						<div class="thumbnail" align="center">
								
								<% if(list.isEmpty()) { %>
									<!--등록된 게시글이 없을 경우-->
									등록된 게시글이 없습니다.
								<% } else { %>
								 	<!--등록된 게시글이 있을 경우-->
									<% for(Board b : list) { %>
							<input type="hidden" value="<%= b.getBoardNo() %>">
						<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20120221_8%2Fdhykim979_1329829393976q0ps9_JPEG%2F%25C4%25C5%25C4%25C9%25C0%25CD.jpg&type=a340">
								<p>
								<%= b.getTitle() %> <br>
								<%= b.getBoardNo() %>  | <%= b.getWriteDate() %> <br>
								
								</p>
								
							</div>
				<% } %>
			<% } %>
							
						</div>
			<div id="content2">      
				<div id="content_4" class="display-test inline" ><h4>자유게시판</h4>
				<hr>
				<table class="list-area" align="left">
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
				</table>
				</div><!--
				--><div id="content_5" class="display-test inline" ><h4>유머게시판</h4>
					<hr>
					<table class="list-area" align="left">
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
					</table>
				</div>
				</div>
			<div id="content3">      
				<div id="content_6" class="display-test inline" ><h4>먹빵투어 메이트</h4>
				<hr>
				<table class="list-area" align="left">
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
					<tr>
						<td width="80" colspan="2">제목</td>
					</tr>
					<tr>
						<td width="80">작성자</td><td width="80">시간</td>
					</tr>
				</table>
				</div><!--
				--><div id="content_7" class="display-test inline" ><h4>베이킹 레시피</h4>
					<hr>
					<table class="list-area" align="left">
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
						<tr>
							<td width="80" colspan="2">제목</td>
						</tr>
						<tr>
							<td width="80">작성자</td><td width="80">시간</td>
						</tr>
					</table>
				</div>
				</div>
			<div id="content3">      
				<div id="content_6" class="display-test inline" ><h4>공동구매</h4>
				<hr>
				
				
				
				
				
				
				</div><!--
				--><div id="content_7" class="display-test inline" ><h4>이벤트</h4>
					<hr>
				
				
				
				
				
				
				
				
				
				</div>
				</div>
			</div>
		</div>














          
        </div>







    </div>
</body>
</html>