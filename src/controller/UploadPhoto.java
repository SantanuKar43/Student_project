package controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import dao.PhotoDao;
import db.Photo;

@WebServlet("/controller.UploadPhoto")
public class UploadPhoto extends HttpServlet {
	private boolean isMultipart;
	   private String filePath=GetPhoto.path;
	   private int maxFileSize = 50*1024*1024;
	   private int maxMemSize = 4*1024*1024;
	   private File file ;
	   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = (String)req.getSession().getAttribute("email");
		String address=null;
		 // Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(req);
	      
	      if( !isMultipart ){
	    	 System.out.println("not multipart");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(req);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();

	     
	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {
	            // Get the uploaded file parameters
	            String fieldName = fi.getFieldName();
	            String fileName = fi.getName();
	            String contentType = fi.getContentType();
	            boolean isInMemory = fi.isInMemory();
	            long sizeInBytes = fi.getSize();
	            // Write the file
	            if( fileName.lastIndexOf("\\") >= 0 ){
	               file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
	               
	            }else{
	               file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	               
	            }
	            Photo p = new Photo();	            
				p.setEmail(email);
				p.setAddress(fileName);
				String id = PhotoDao.uploadPhoto(p);
				fi.write( file ) ;
	            System.out.println("Uploaded Filename: " + fileName);
	            resp.sendRedirect("userdash.jsp");
	         }
	      }
	     
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }
	   }
	   public void doGet(HttpServletRequest request, 
	                       HttpServletResponse response)
	        throws ServletException, java.io.IOException {
	        
	        throw new ServletException("GET method used with " +
	                getClass( ).getName( )+": POST method required.");
	   } 
	
	}

