<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    #head-area{
        margin-bottom: 20px;
    }
    #freeList{
        border: 1px solid white;
        width: 100%;
        box-sizing: border-box;
        text-align: center;
    }
</style>
</head>
<body>
    <div id="wrap">
        <div id="wrap-left">
            <%@ include file="boardBar.jsp" %>
        </div>
        <div id="wrap-right">
            <div id="head-area">
                <button class="head-btn">전체보기</button>
                <button class="head-btn">사는얘기</button>
                <button class="head-btn">유머</button>
                <button class="head-btn">고민/질문</button>
                <button class="head-btn">정보</button>
                <span>전체글 수 : 00000</span>
                <input type="checkbox">공지감추기
                <select name="list" id="">
                    <option value="">10</option>
                    <option value="">15</option>
                    <option value="">20</option>
                </select>
            </div>
            
            <table border="1" id="freeList">
                <thead>
                    <tr>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성시간</th>
                        <th>조회수</th>
                        <th>추천수</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>게시글1 [댓글수]</td>
                        <td>닉네임</td>
                        <td>createDate</td>
                        <td>100</td>
                        <td>22</td>
                    </tr>
                    <tr>
                        <td>게시글1 [댓글수]</td>
                        <td>닉네임</td>
                        <td>createDate</td>
                        <td>100</td>
                        <td>22</td>
                    </tr>
                    <tr>
                        <td>게시글1 [댓글수]</td>
                        <td>닉네임</td>
                        <td>createDate</td>
                        <td>100</td>
                        <td>22</td>
                    </tr>
                </tbody>
            </table>

            <div align="center" class="paging-area">


            </div>
        </div>







    </div>
</body>
</html>