<%@page import="dao.PhotoDao"%>
<%@page import="db.Photo"%>
<%@page import="db.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email=(String)session.getAttribute("email");
    	User u = UserDao.getUser(email);
    	String address=null;
        Photo photo = PhotoDao.getPhoto(email);
    	try{
    		address = photo.getAddress();
    	}
    	catch(NullPointerException e){
    		address="default.jpg";
    	}
    %>
<div class="container">

		<div class="userdetails row">
			<div class="col-xs-5 col-lg-5" style="border-right:1px solid #aaa;padding:0px">
				<div style="background-image:url('controller.GetPhoto?image=<%=address %>');height:200px;width:200px;background-size:cover;border:1px solid gainsboro;background-position:center;
					border-radius:100px;display:inline-block">
				</div>
			</div>
			<div class="col-xs-7 col-lg-7">
			<table class="table borderless">
    			<tbody>
      				<tr>
        				<td>Name :</td>
        				<td><%=u.getName() %></td>
      				</tr>
      				<tr>
        				<td>Gender :</td>
        				<td><%=u.getGender() %></td>
      				</tr>
      				<tr>
        				<td>Date of Birth :</td>
        				<td><%=u.getDob() %></td>
      				</tr>
      				<tr>
        				<td>Email :</td>
        				<td><%=u.getEmail() %></td>
      				</tr>
    			</tbody>
			</table>
			<a href="editprofile.jsp" class="btn btn-custom" style="margin-top:10px">Edit profile</a>
			</div>
		</div>
	</div>
