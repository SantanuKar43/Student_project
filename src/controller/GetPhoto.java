package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller.GetPhoto")
public class GetPhoto extends HttpServlet {
	public static String path = "c:\\sbimg\\";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = req.getParameter("image");
		resp.setContentType("image/jpeg");
		File f = new File(path+filename);
		BufferedImage image = ImageIO.read(f);
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}

}
