<%@page import="db.Photo"%>
<%@page import="dao.PhotoDao"%>
<%@page import="db.User"%>
<%@page import="dao.UserDao"%>
<%@page import="db.Request"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.RequestDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <div class="container">
		<h1 style="text-align:center;font-family:'Arima Madurai',cursive;font-weight:600;color:indigo"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Friend Requests</h1>
		<ul style="list-style:none"> 
<%
	String email = (String)session.getAttribute("email");
	List list = RequestDao.getRequests(email);
	Iterator i = list.iterator();
	if(i.hasNext())
	{
	while(i.hasNext()) {
		Request r = (Request)i.next();
		if(r.getState()==0){
			String sender = r.getSender();
			User u = UserDao.getUser(sender);
			Photo p=PhotoDao.getPhoto(u.getEmail());
	    	String address=null;
	    	try{
	    	address=p.getAddress();
	    	}
	    	catch(NullPointerException e)
	    	{
	    		address="default.jpg";
	    	}
			%>
			<li style="border-bottom:1px solid #aaa">
				<div style="padding:10px">
						<div style="background-image:url('controller.GetPhoto?image=<%=address %>');height:80px;width:80px;background-size:cover;border:1px solid gainsboro;background-position:center;
						border-radius:100px;display:inline-block;">
						</div>
						<div style="display:inline-block;position:relative;bottom:30px;padding-left:20px"><a href="friendprofile.jsp?email=<%=u.getEmail()%>"><%=u.getName() %></a></div>
						<div style="display:inline-block;width:60%">
							<a href="controller.AcceptRequest?accept=false&sender=<%=sender %>" style="float:right;position:relative;bottom:15px;margin-left:10px" class="btn btn-default"><i class="fa fa-times" aria-hidden="true"></i> Reject</a>
							<a href="controller.AcceptRequest?accept=true&sender=<%=sender %>" style="float:right;position:relative;bottom:15px" class="btn btn-custom"><i class="fa fa-check" aria-hidden="true"></i> Accept</a>
						</div>
				</div>
			</li>
			<% }
		}
	}
			else { %>
				<h3 style="font-family:'Arima Madurai',cursive;font-weight:600;">You have no Friend Requests</h3>
			<%	
	
	}
%>
	</ul>
	</div>