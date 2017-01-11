package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/controller.Like")
public class Like extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String receiver = req.getParameter("email");
		String liker = (String)req.getSession().getAttribute("email");
		UserDao.setLike(receiver, liker);
		resp.sendRedirect("friendprofile.jsp?email="+receiver);
	
	}
}
