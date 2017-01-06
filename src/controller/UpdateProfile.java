package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import db.User;

@WebServlet("/controller.UpdateProfile")
public class UpdateProfile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		
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
		
		
		User u = new User();
		u.setEmail(email);
		u.setName(name);
		u.setDob(dob);
		u.setGender(gender);
		UserDao.updateProfile(u);
		resp.sendRedirect("userprofile.jsp");
		
		
	}
}
