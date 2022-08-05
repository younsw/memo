<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
 		<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<form id="loginForm">
			<section class="section d-flex justify-content-center align-items-center" >	
			 	<div class="col-3">
			 		<h2 class="text-center">로그인</h2>
			 		<input class="form-control" type="text" id="idInput" placeholder="Username"> <br>
			 		<input class="form-control" type="password" id="passwordInput" placeholder="passwoad"><br>
			 		<button type="submit" id="loginId" class="btn btn-block">로그인</button>
			 		<div class="text-center">
			 			<a href="/user/signup/view">회원가입</a>
			 		</div>
			 	</div>
			 </section>
		</form>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
	
	$(document).ready(function() {
		
		$("#loginForm").on("submit", function(e) {
			
			// 해당하는 이벤트에 포함된 모든 기능을 중단한다
			e.preventDefault();
			
			let id = $("#idInput").val();
			let password = $("#passwordInput").val();
			
			if(id == "") {
				alert("아이디를 입력하세요");
				return false;
			}
			
			if(password == "") {
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			$.ajax({
				type:"post",
				url:"/user/signin",
				data:{"loginId":id, "password":password},
				success:function(data) {
					if(data.result == "success") {
						location.href = "/post/list/view";
					} else {
						alert("아이디와 비밀번호가 일치하지 않습니다");
					}
				},
				error:function() {
					alert("로그인 에러");
				}
				
				
			});
			
		});
		
	});
	
	</script>
	
</body>
</html>