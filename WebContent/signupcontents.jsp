<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div style="margin-bottom:90px">
 <div class="container">    
        <div class="col-md-8">
        
        <section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1 style="font-family: 'Arima Madurai', cursive">SIGN UP</h1>
                    <form role="form" action="controller.SignUp" method="post" id="login-form" autocomplete="off">
                     	<div class="form-group">
                            <label for="name" class="sr-only">Name</label>
                            <input type="text" name="name" id="name" class="form-control" placeholder="Name" required>
                        </div>
                        <div class="form-group">
                            <label for="email" class="sr-only">Email</label>
                            <input type="email" name="email" id="email" class="form-control" placeholder="Email (somebody@example.com)" required>
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
                        <div class="form-group">
                            <label for="pwd" class="sr-only">Password</label>
                            <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <label for="cpwd" class="sr-only">Confirm Password</label>
                            <input type="password" name="cpwd" id="cpwd" class="form-control" placeholder="Confirm Password" required>
                        </div>
                        
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Sign Up">
                    </form>
                    <hr>
                    <p style="text-align:center">Already registered?<a href="index.jsp"> Sign in</a></p>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>
        
        </div>
        <div class="col-md-4" style="padding:100px 0px 0px 50px">
        	<%	
        		String msg = request.getParameter("msg");
        		if(msg!=null) { 
        	%>
        	<div class="">
        		<h1 class="text-danger">Registration Failed.</h1>
        		<p><%=msg %></p>
        	</div>
        	<% } %>
        </div>
        
    </div>
    </div>