<%@page import="dao.PhotoDao"%>
<%@page import="db.Photo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String email=(String)session.getAttribute("email");
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
				
					<form action="controller.UploadPhoto" method="post" enctype="multipart/form-data">
					<ul class="updatephoto" style="list-style:none">
						<li><input type="file" value="Choose Photo" name="file" size="50"></li>
						<li><input type="submit" class="btn btn-default" value="Update Photo"></li>
					</ul>
					</form>
				
			</div>
			<div class="col-xs-7 col-lg-7">
			
			<div class="form-wrap">
                <h1 style="font-family: 'Arima Madurai', cursive">EDIT PROFILE</h1>
                    <form role="form" action="controller.UpdateProfile" method="post" id="login-form" autocomplete="off">
                     	<div class="form-group">
                            <label for="name" class="sr-only">Name</label>
                            <input type="text" name="name" id="name" class="form-control" placeholder="Name" required>
                        </div>
                        <div class="form-group">
                            <label for="gender" class="sr-only">Gender</label>
                            <select class="form-control" id="gender" name="gender" required>
                            	<option disabled style="display:none" selected value="">Gender</option>
    							<option value="male">Male</option>
    							<option value="female">Female</option>
  							</select>
                        </div>
                        <div class="form-group">
                            <label for="pwd" class="sr-only">Date of Birth</label>
                            <input type="text" onfocus="(this.type='date')" onblur="(this.type='text')" name="dob" id="dob" class="form-control" placeholder="Date of Birth" required>
                        </div>
                        <input type="submit" id="btn-login" style="width:48%;margin-right:3%" class="btn btn-custom" value="Update Profile">
                        <a href="userprofile.jsp" style="width:48%" class="btn btn-default">Cancel</a>
                    </form>
        	    </div>
			
			</div>
		</div>
	</div>
