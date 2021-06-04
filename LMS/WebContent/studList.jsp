<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.dev.vo.Member" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Member> list1 = (ArrayList<Member>) request.getAttribute("list1");
		if(!list1.isEmpty()) {%>
		<table border="1">
		 <tr><th>과목번호</th><th>과목명</th></tr>
		 
		 	<% for(int i = 0; i<list1.size(); i++) {
		 			Member member = list1.get(i);%>
		 			
		 			<tr><td><%=member.getSubjectNum() %></td>
		 				<td><%=member.getSubjectName() %></td>
		 			</tr>
		 	<%		}
		 } else {
		 	out.print("<h3>등록된 과목이 없습니다.</h3>");
		 }
		 %>
		 </table>
		<a href="studMenu.jsp">Menu</a>
</body>
</html>