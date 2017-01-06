<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1 style="font-family: 'Arima Madurai', cursive">LOGIN WITH YOUR EMAIL</h1>
                    <form role="form" action="controller.SignIn" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                            <label for="email" class="sr-only">Email</label>
                            <input type="email" name="email" id="email" class="form-control" placeholder="somebody@example.com" required>
                        </div>
                        <div class="form-group">
                            <label for="key" class="sr-only">Password</label>
                            <input type="password" name="pwd" id="key" class="form-control" placeholder="Password" required>
                        </div>
                        
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Login">
                    </form>
                    <a href="javascript:;" class="forget" data-toggle="modal" data-target=".forget-modal">Forgot your password?</a>
                    <hr>
                    <p style="text-align:center">Not registered yet?<a href="signup.jsp"> Sign up</a></p>
                     	<%
    		String msg = request.getParameter("msg");
    		if(msg!=null) {
    			%>
    			<p style="font-size:14px;text-align:center;color:red">
    			<%=msg %></p>
    			<%
    		}
    		%>
        	    </div>
        	   
    		</div> <!-- /.col-xs-12 -->
    	
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>