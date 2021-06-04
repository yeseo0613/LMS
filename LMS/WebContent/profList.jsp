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
	<% ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
	   if(!list.isEmpty()) {%>
	   <table border="1">
	   	<tr><th>과목번호</th><th>과목명</th><th>최대인원</th><th>수강인원</th></tr>
	   	
	   		<% for(int i = 0; i<list.size(); i++) {
	   				Member member = list.get(i);%>
	   				
	   				<tr><td><%=member.getSubjectNum() %></td>
	   					<td><%=member.getSubjectName() %></td>
	   					<td><%=member.getStudentNum() %></td>
	   					<td><%=member.getTotalStud() %></td>
	   				</tr>
	   		<%		}
	   	} else {
	   		out.print("<h3>등록된 과목이 없습니다.</h3>");
	   	}
	   	%>
	   	 </table>
	   <a href="profMenu.jsp">Menu</a>
</body>
</html>