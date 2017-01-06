<%@page import="dao.RequestDao"%>
<%@page import="db.Request"%>
<%@page import="dao.StatusDao"%>
<%@page import="dao.PhotoDao"%>
<%@page import="db.Photo"%>
<%@page import="db.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email=request.getParameter("email");
    	User u=UserDao.getUser(email);
    	Photo p=PhotoDao.getPhoto(email);
    	String address=null;
    	try{
    	address=p.getAddress();
    	}
    	catch(NullPointerException e)
    	{
    		address="default.jpg";
    	}
    	
    	String s= StatusDao.getStatus(email);
    %>
    
 <div class="container" style="text-align:center;">
		<div style="background-image:url('controller.GetPhoto?image=<%=address %>');height:200px;width:200px;background-size:cover;border:1px solid gainsboro;background-position:center;
					border-radius:100px;display:inline-block;margin-top:10px;">
		</div>
		<h2 style="font-family: 'Arima Madurai', cursive;font-weight:600;"><%=u.getName() %></h2>
		
			
			<div style="width:40%;height:auto;display:inline-block;word-wrap: break-word;margin-top:5px;text-align:center; border-top:1px solid #aaa">
		
				<p style="font-family: 'Lobster', cursive; font-size:18px;padding-top:10px;color:#90A4AE;">
				<i class="fa fa-quote-left" aria-hidden="true" style="color:indigo;font-size:20px;padding-right:5px"></i><%=s %><i class="fa fa-quote-right" aria-hidden="true" style="color:indigo;font-size:20px;padding-left:5px;"></i>
				</p>
			</div>
			<%
				String sender = (String)session.getAttribute("email");
				String receiver = email;
				Request r = RequestDao.getRequest(receiver,sender);
				Request r1 = RequestDao.getRequest(sender,receiver);
				if(r==null && r1==null){
			%>
			<div style="margin-top:20px;"> 
				<a href="controller.SendRequest?receiver=<%=email %>" class="btn btn-custom"><i class="fa fa-plus" aria-hidden="true"></i> Add Friend</a>
			</div>	
			<%} else if(r!=null && r.getState()==0 && r1==null){%>	
			
			<div style="margin-top:20px;"> 
				<a href="#" class="btn btn-default">Friend Request Sent</a>
			</div>
			<%} else if(r==null && r1!=null && r1.getState()==0){ %>
			
			<div style="margin-top:20px;"> 
				<a href="controller.AcceptRequest?accept=true&sender=<%=receiver %>"  class="btn btn-custom"><i class="fa fa-check" aria-hidden="true"></i> Accept</a>
				<a href="controller.AcceptRequest?accept=false&sender=<%=receiver %>" class="btn btn-default"><i class="fa fa-times" aria-hidden="true"></i> Reject</a>
			</div>
			
			<%}else if((r!=null && r.getState()==1) || (r1!=null && r1.getState()==1)){ %>
			 <p>
				<i class="fa fa-check-circle-o fa-4x" aria-hidden="true" style="color:green;"></i>
			</p>
	
			<div class="buttons row" style="padding-top:20px;width:30%;margin:auto;">
				<a type="button" class="btn btn-primary " style="background-color:indigo;margin:2px;"><i class="fa fa-envelope" aria-hidden="true"></i> Message</a>
				<a href="controller.AcceptRequest?accept=false&sender=<%=receiver %>" type="button" class="btn btn-default " style="margin:2px;"><i class="fa fa-times fa-lg" aria-hidden="true"></i> Remove</a>
			</div>
			<%} %>

	</div>