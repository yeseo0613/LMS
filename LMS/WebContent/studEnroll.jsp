<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.dev.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Subject</h1>
	<form action="studSearch.do" method="post">
		ID : <input type="text" name="subjectNum"><br>
		<input type="hidden" name="job" value="subjectSearch">
		<input type="submit" value="Search">
	</form>
	<%
		Member member = (Member)request.getAttribute("member");
		if(member != null) {
	%>
	<form action="studEnroll.do" method="post">
		ID : <input type="text" name="subjectNum" readonly value="${member.subjectNum }"><br>
		SUBJECT : <input type="text" name="subjectName" readonly value="${member.subjectName }"><br>
		<input type="submit" value="Enroll">
	</form>
	<%}else { %>
		${result }
	<%} %>
</body>
</html>