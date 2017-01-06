
<%@page import="db.Photo"%>
<%@page import="dao.PhotoDao"%>
<%@page import="db.User"%>
<%@page import="dao.UserDao"%>
<%@page import="dao.StatusDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email=(String)session.getAttribute("email");
    	User u = UserDao.getUser(email);
    	String address=null;
    	String status=StatusDao.getStatus(email);
    	if(status==null) {
    		status="Hi there! I'm using StudentBook";
    	}
    	Photo photo = PhotoDao.getPhoto(email);
    	try{
    		address = photo.getAddress();
    	}
    	catch(NullPointerException e){
    		address="default.jpg";
    	}
    	
    %>
    
    <div class="container" style="text-align:center;">
		<div style="background:url('controller.GetPhoto?image=<%=address %>');height:200px;width:200px;background-size:cover;border:1px solid gainsboro;background-position:center;
					border-radius:100px;display:inline-block;margin-top:10px;">
		</div>
		<h2 style="font-family: 'Arima Madurai', cursive;font-weight:600;"><%=u.getName() %></h2>
		
		<div id="status">
		
			<div style="width:40%;height:auto;display:inline-block;word-wrap:break-word;margin-top:20px;text-align:center;border-top:1px solid #aaa">
		
				<p style="font-family: 'Lobster', cursive; font-size:18px;padding-top:10px;color:#90A4AE;">
				<i class="fa fa-quote-left" aria-hidden="true" style="color:indigo;font-size:20px;padding-right:5px"></i><%=status %><i class="fa fa-quote-right" aria-hidden="true" style="color:indigo;font-size:20px;padding-left:5px;"></i>
				</p>
			</div>
			<a style="padding-left:5px;position:fixed;margin-top:20px;" onclick="editStatus()"> <i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i></a>
		</div>
	</div>