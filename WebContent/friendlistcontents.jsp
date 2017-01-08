<%@page import="dao.UserDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="dao.RequestDao"%>
<%@page import="java.util.List"%>
<%@page import="db.Request"%>
<%@page import="db.User"%>

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
    		%>
    		//code for displaying friends
    		
    		
    		<%
    	}
    %>
