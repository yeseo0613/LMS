<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>YongIn LMS</h1>
	<form action="login.do" method="post">
		ID : <input type="text" name="id"><br>
		Password : <input type="password" name="pwd"><br>
		<label><input type="radio" name="member" value="prof">Professor</label>
		<label><input type="radio" name="member" value="student">Student</label><br>
		<input type="submit" value="LogIn">
	</form>
</body>
</html>