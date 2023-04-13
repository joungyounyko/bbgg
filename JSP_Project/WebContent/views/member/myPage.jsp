<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보를 바꿔줘 마이페이지?</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  
<style>

    .outer{
        background-color: rgb(198, 199, 199);
        width: 1000px;
        margin: auto;
        color: aliceblue;
        margin-top: 5px;
    }
    #mypage-form input{margin: 5px;}

</style>
</head>
<body>

    <%@ include file="../common/menubar.jsp" %>
    
    <%
    String userId = 
    	loginUser.getUserId();
    String userName=
    	loginUser.getUserName();

    String phone=
        	(loginUser.getPhone() == null)? "" :loginUser.getPhone();

    String email=
        	(loginUser.getEmail() == null)? "" :loginUser.getEmail();

    String address=
        	(loginUser.getAddress() == null)? "" :loginUser.getAddress();

    String interest=
        	(loginUser.getInterest() == null)? "" :loginUser.getInterest();
    
    //System.out.println(interest); 

    %>
    
    
    <div class="outer">
     <br>
     <h2 align="center">마이페이지</h2>
    
    <form action="<%=contextPath%>/update.me" method="post" id="mypage-form">
    
    
     <table align="center">
    
        <tr>
            <td>아이디</td>
            <td><input type="text" name="userId" readonly value="<%= userId %>" maxlength="12" required>
            </td>
            <td></td>

    
        </tr>
    
        <tr>
            <td>이름</td>
            <td><input type="text" name="userName" value="<%= userName %>" maxlength="5" required></td>
            <td></td>
        </tr>
    
        <tr>
            <td>폰</td>
            <td><input type="text" name="phone" value="<%= phone %>" placeholder="-포함해서"></td>
            <td></td>
        </tr>
    
        <tr>
            <td>메일</td>
            <td><input type="text" value="<%= email %>" name="email"></td>
            <td></td>
        </tr>
    
    
        <tr>
            <td>주소</td>
            <td><input type="text"  value="<%= address %>" name="address"></td>
            <td></td>
        </tr>
    
    
        <tr>
            <td>취미</td>
            <td colspan="2">
                <input type="checkbox" id="travel" name="interest" value="여행">
                <label for="travel">여행</label>
                <input type="checkbox" id="workout" name="interest" value="운동">
                <label for="workout">운동</label>
                <input type="checkbox" id="bread" name="interest" value="빵">
                <label for="bread">빵</label>
    
                <br>
    
                <input type="checkbox" id="livealone" name="interest" value="자취">
                <label for="livealone">자취</label>
                <input type="checkbox" id="market" name="interest" value="중고거래">
                <label for="market">중고거래</label>
                <input type="checkbox" id="java" name="interest" value="java">
                <label for="java">자바</label>
    
    
            </td>
        </tr>
    
    

     </table>
     <br>

    <!-- <%= interest %>-->
    <script>

       // console.log('<%= interest %>');

        var interest = '<%= interest %>';

      //  console.log( $('input[type=checkbox]')); ?? 왜안떠?

        // 모든 체크박스가 배열에 담김
      $('input[type=checkbox]').each(function(){
        // 순차적으로 접근한 chekcbox 의 value속성값이 intertest에포함되어있을경우체크
        // checked 속성 attr(속성명, 속성값);

        // 자바스크립트의 indexOf -> 찾고자하는 문자가 없을 경우 -1을 리턴해줌..
        // search메소드가 똑같은 역할로 찾아줌

        // 제이쿼리에서 value속성값을 리턴해주는 메소드 : val()
        // 제이쿼리에서 현재 접근한 요소 지칭 : $(this)
        if(interest.search($(this).val()) != -1){ // 포함되어있을 경우
            $(this).attr('checked',true);

        };




      });


    </script>
    
     <div align="center">
        <button type="submit" class="btn btn-secondary">정보수정</button>
        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#updatepwd">비번수정</button>
        <button type="button" class="btn btn-danger">탈퇴</button>
        <br>    <br>
     </div>
    </div>
    
    <br>    <br>
    </form>
  
  <!-- 비밀번호 변경 모달창 -->
  <div class="modal" id="updatepwd" >
  <div class="modal-dialog">
    <div class="modal-content">
    
    <!-- Modal Header -->
    <div class="modal-header">
        <h4 class="modal-title">비밀번호 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
    </div>
    
    <!-- Modal body -->
    <div class="modal-body">
        <form action="<%= contextPath %>/updatePwd.me" method="post">
        <!--  현재 비번 / 변경 비번 / 변경할비번 재입력 -->
            <div class="form-group">
              <label for="userPwd">현재 비번 : </label>
              <input type="password" class="form-control" required id="userPwd" 
              placeholder="비번 입력해주세요" name="userPwd">
            </div>
            <div class="form-group">
              <label for="updatePwd">변경 비번 : </label>
              <input type="password" class="form-control" required id="updatePwd" 
              placeholder="변경할 비번 입력해주세요" name="updatePwd">
            </div>
              <div class="form-group">
              <label for="updatePwd" >변경 비번확인 : </label>
              <input type="password" class="form-control"   
              placeholder="변경할 비번 다시 입력해주세요" name="checkPwd">
            </div>

            <button type="submit" class="btn btn-danger" onclick="return validatePwd()">비번수정</button>
            
            <!--  사용자를 판별할수 있는 유저번호도 넘겨줌 -->
             <input type="hidden" value="<%= loginUser.getUserNo() %>" name="userNo">   
                
            <script>
              
              function validatePwd(){

                if($('#updatePwd').val() != $('input[name=checkPwd]') .val()){
                  alert('비번동일하게');
                  $('input[name=checkPwd]').focus();
                  return false;

                }else{
                  return true;
                }

              };
                
                </script>
                
                
                
                
                
                
                
                
                
                
                
                
              </form>
        </div>

        </div>
    </div>
    </div>
    
    
    
    
    
    </body>
</html>