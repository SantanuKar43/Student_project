<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%
	String email=(String)session.getAttribute("email");
	if(email==null)
		{
			System.out.println(email);
			response.sendRedirect("index.jsp?msg=Please login to continue");
			return;
		}
    %>
	<jsp:include page="usertop.jsp"></jsp:include>
	<jsp:include page="userdashcontents.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>