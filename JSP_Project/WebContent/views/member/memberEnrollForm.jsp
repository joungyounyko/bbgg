<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style>

    .outer{
        background-color: rgb(198, 199, 199);
        width: 1000px;
        margin: auto;
        color: aliceblue;
        margin-top: 5px;
    }
    #enroll-form input{margin: 5px;}

</style>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>


<div class="outer">
 <br>
 <h2 align="center">회원가입</h2>

<form action="<%=contextPath%>/insert.me" method="post" id="enroll-form">


 <table align="center">

    <tr>
        <td>아이디</td>
        <td><input type="text" name="userId" maxlength="12" required>
        <button type="button">중복확인</button></td>
        <td></td>
        <!-- 중복확인 나중에-->

    </tr>

    <tr>
        <td>비번</td>
        <td><input type="password" maxlength="15" required></td>
        <td></td>
    </tr>
    <tr>
        <td>비번확인</td>
        <td><input type="password" name="userPwd" maxlength="15" required></td>
        <td></td>
    </tr>



    <tr>
        <td>이름</td>
        <td><input type="text" name="userName" maxlength="5" required></td>
        <td></td>
    </tr>

    <tr>
        <td>폰</td>
        <td><input type="text" name="phone" placeholder="-포함해서"></td>
        <td></td>
    </tr>

    <tr>
        <td>메일</td>
        <td><input type="text" name="email"></td>
        <td></td>
    </tr>


    <tr>
        <td>주소</td>
        <td><input type="text" name="address"></td>
        <td></td>
    </tr>


    <tr>
        <td>취미</td>
        <td colspan="2">
            <input type="checkbox" id="travel" name="interest" value="여행"><label for="travel">여행</label>
            <input type="checkbox" id="workout" name="interest" value="운동"><label for="workout">운동</label>
            <input type="checkbox" id="bread" name="interest" value="빵"><label for="bread">빵</label>

            <br>

            <input type="checkbox" id="livealone" name="interest" value="자취"><label for="livealone">자취</label>
            <input type="checkbox" id="market" name="interest" value="중고거래"><label for="market">중고거래</label>
            <input type="checkbox" id="java" name="interest" value="java"><label for="java">자바</label>


        </td>
    </tr>



 </table>


 <div align="center">
    <button type="submit">가입</button>
    <button type="reset">초기화</button>

 </div>
</div>


</form>







</body>
</html>