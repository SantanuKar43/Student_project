package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import db.User;

@WebServlet("/controller.SignIn")
public class SignIn extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		
		User u=UserDao.getUser(email);
		try{
			if(u.getPassword().equals(pwd))
			{
				HttpSession session = req.getSession();
				session.setAttribute("email",email);
				res.sendRedirect("userdash.jsp");
			}
			else
			{
				res.sendRedirect("index.jsp?msg=Password incorrect.");
			}
		}
		catch(NullPointerException e) {
			res.sendRedirect("index.jsp?msg=Account doesn't exist.");
		}
	}
}

