<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%if(session.getAttribute("email")==null) {%>
    <jsp:include page="top.jsp"></jsp:include>
<%}else {%>
	<jsp:include page="usertop.jsp"></jsp:include>
	<%} %>
<jsp:include page="searchuserscontents.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>