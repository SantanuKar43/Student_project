package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RequestDao;
import db.Request;

@WebServlet("/controller.SendRequest")
public class SendRequest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String receiver=req.getParameter("receiver");
		String sender=(String)req.getSession().getAttribute("email");
		
		Request r=new Request();
		r.setReceiver(receiver);
		r.setSender(sender);
		r.setState(0);
		
		RequestDao.sendRequest(r);
		resp.sendRedirect("friendprofile.jsp?email="+receiver);
	}

}
