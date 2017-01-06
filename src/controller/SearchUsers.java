package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.User;

import dao.UserDao;

@WebServlet("/controller.SearchUsers")
public class SearchUsers extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("search");
		List list = UserDao.searchUsers(name);
		
		Iterator i = list.iterator();
		while(i.hasNext()) {
			User u = (User)i.next();
			System.out.println(u.getName());
		}
		
	}

}
