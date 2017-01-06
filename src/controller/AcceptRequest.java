package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RequestDao;

@WebServlet("/controller.AcceptRequest")
public class AcceptRequest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean accept = Boolean.parseBoolean(req.getParameter("accept"));
		String sender = req.getParameter("sender");
		HttpSession session = req.getSession();
		String receiver = (String)session.getAttribute("email");
		RequestDao.handleRequest(sender, receiver, accept);
		resp.sendRedirect("requests.jsp");
	}

}
