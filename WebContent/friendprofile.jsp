<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String friend = request.getParameter("email");
	String email=(String)session.getAttribute("email");
	if(email==null)
		{
			System.out.println(email);
			response.sendRedirect("index.jsp?msg=Please login to continue");
			return;
		}
	if(email.equals(friend)) {
		response.sendRedirect("userdash.jsp");
	}
    %>
	
	<jsp:include page="usertop.jsp"></jsp:include>
	<jsp:include page="friendprofilecontents.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>