<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Subject Enroll</h1>
	<form action="profEnroll.do" method="post">
		ID : <input type="text" name="subjectNum"><br>
		TITLE : <input type="text" name="subjectName"><br>
		# of Student : <input type="text" name="studentNum"><br>
		<input type="submit" value="Enroll">
	</form>
</body>
</html>