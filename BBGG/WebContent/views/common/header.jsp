<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>

<style>

#header{
    width : 1200px;
    height : 120px;
    background-color : rgb(241,227,196);
    padding : none;
    margin : none;
}

#header div{
    box-sizing: border-box;
    float :left;
    height : 100%;
}

#header #header1, #header3{
    width : 20%;
}

#header #header2{
    width: 60%;
}

#header #header1-1, #header1-3, #header2-1, #header2-3, #header3-1, #header3-3{
    width : 20%;
}

#header #header1-2, #header2-2, #header3-2{
    display: flex;
    align-items : center;
    justify-content : center;
    text-align: center;
    width : 60%;
    font-size: 14px;
}

#header #logo{
    height : 50%;
    width : 50%;
    display: flex;
    align-items : center;
    justify-content : center;
    text-align: center;
    background-color: #8cc2a4;
    border-radius: 10px;
    font-size : 20px;
}

</style>

</head>
<body>
	<div id="header">
        <div id="header1">
            <div id="header1-1"></div>
            <div id="header1-2">빵집 / 커뮤니티</div>
            <div id="header1-3"></div>
        </div>
        <div id="header2">
            <div id="header2-1"></div>
            <div id="header2-2"><div id="logo">빵빵곡곡</div></div>
            <div id="header2-3"></div>
        </div>
        <div id="header3">
            <div id="header3-1"></div>
            <div id="header3-2">로그인 / 회원가입</div>
            <div id="header3-3"></div>
        </div>
    </div>
</body>
</html>