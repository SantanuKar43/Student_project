package dao;

import java.io.File;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import db.Photo;
import db.Status;
import db.User;

public class PhotoDao {
	public static String uploadPhoto(Photo p) throws ConstraintViolationException {
		String i="";
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		t.begin();
		Photo p1 = (Photo)session.get(Photo.class,p.getEmail());
		if(p1!=null) {
			File f = new File("c:\\sbimg\\"+p1.getAddress());
			f.delete();
			p1.setAddress(p.getAddress());
			session.update(p1);
		}
		else{
			session.save(p);
		}
		
		t.commit();
		session.close();
		return i;
	}
	
	public static Photo getPhoto(String email) {
		Photo p=null;
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		 Criteria criteria = session.createCriteria(Photo.class);
		 criteria.add(Restrictions.eq("email", email));
		 p = (Photo) criteria.uniqueResult();
		 if (p!=null) {
			 System.out.println("Photo found:");
			 System.out.println(p.getEmail() + " - " + p.getAddress());
		 
		 }
		return p;
	}

}
