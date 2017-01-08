<%@page import="dao.PhotoDao"%>
<%@page import="db.Photo"%>
<%@page import="dao.UserDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.RequestDao"%>
<%@page import="java.util.List"%>
<%@page import="db.Request"%>
<%@page import="db.User"%>
<div class="container">
		<h1 style="text-align:center;font-family:'Arima Madurai',cursive;font-weight:600;color:indigo"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Your Friends</h1>
		<ul style="list-style:none"> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email = (String)session.getAttribute("email");
    	List list = RequestDao.getFriendList(email);
    	Iterator i = list.iterator();
    	User u =null;
    	while(i.hasNext()) {
    		Request r = (Request)i.next();
    		if(r.getSender().equals(email)){
    			u = UserDao.getUser(r.getReceiver());
    		}
    		else if(r.getReceiver().equals(email)) {
    			u = UserDao.getUser(r.getSender());
    		}
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
				</div>
			</li>
    		<%
    	}
    %>
    	</ul>
	</div>
