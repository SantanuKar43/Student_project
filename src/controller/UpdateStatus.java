package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StatusDao;
import db.Status;

@WebServlet("/controller.UpdateStatus")
public class UpdateStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		String email = (String)req.getSession().getAttribute("email");
		
		Status s=new Status();
		s.setEmail(email);
		s.setStatus(status);
		
		StatusDao.updateStatus(s);
		resp.sendRedirect("userdash.jsp");
	}
}
