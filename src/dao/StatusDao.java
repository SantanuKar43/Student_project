package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import db.Status;

public class StatusDao {
	public static void updateStatus(Status s) {
		
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		t.begin();
		Status s1 = (Status)session.get(Status.class,s.getEmail());
		if(s1!=null) {
			s1.setStatus(s.getStatus());
			session.update(s1);
		}
		else{
			session.save(s);
		}
		t.commit();
		session.close();
	}
	public static String getStatus(String email) {
		String status="";
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		t.begin();
		try{
		status = ((Status)session.get(Status.class,email)).getStatus();
		}
		catch(NullPointerException e){
			status="Hi there! I'm using StudentBook!";
		}
		t.commit();
		session.close();
		return status;
		
	}
	
}
