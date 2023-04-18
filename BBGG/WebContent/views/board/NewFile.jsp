<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 메인</title>
<style>
	div{
            border: 1px solid red;
            box-sizing: border-box;
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
	  #content2>div{
          height: 300px;
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
	.ward{
        height:1200px;
    }
    
</style>


</head>
<body>
	
	<%@ include file="../board/boardBar.jsp" %>
	

    <div id="ward">
	<div id="content">
		<div id="content_1"><h3>커뮤니티</h3></h2>
			<br>
				<div class="list-area">
				<h2 align="center">리뷰게시판</h2>
				<div class="thumbnail" align="center">
				<input type="hidden" value="">
				<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20120221_8%2Fdhykim979_1329829393976q0ps9_JPEG%2F%25C4%25C5%25C4%25C9%25C0%25CD.jpg&type=a340">
						<p>
						no. / <br>
						조회수 :
						</p>
						
					</div>
				</div>
	<div id="content2">      
		<div id="content_4" class="display-test inline" ><h4>자유게시판</h4></div><!--
		--><div id="content_5" class="display-test inline" ><h4>유머게시판</h4></div>
		</div>
	</div>
</div>
</div>
</body>
</html>