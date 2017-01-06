package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;

import dao.UserDao;
import db.User;

@WebServlet("/controller.SignUp")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String pwd = req.getParameter("pwd");
		String cpwd = req.getParameter("cpwd");
		
		//code to convert name to titlecase
		name = name.trim();
		name = name.toLowerCase();
		char temp[] = name.toCharArray();
		temp[0] = Character.toTitleCase(temp[0]);
		for(int ch = 0;ch<temp.length;ch++){
			if(Character.isWhitespace(temp[ch])){
				temp[ch+1] = Character.toTitleCase(temp[ch+1]); 
			}
		}
		name = String.valueOf(temp);
		
		
		User u=new User();
		u.setEmail(email);
		u.setName(name);
		u.setGender(gender);
		u.setPassword(pwd);
		u.setDob(dob);
		try {
			if(cpwd.equals(pwd)) {
				String i=UserDao.register(u);
				System.out.println(i+" registered");
				resp.sendRedirect("signupsuccess.jsp");
			}
			else {
				resp.sendRedirect("signup.jsp?msg=Passwords don't match!");
			}
		}
		catch (ConstraintViolationException e) {
			resp.sendRedirect("signup.jsp?msg="+email+" already exists!");
		}
		
	} 

}
