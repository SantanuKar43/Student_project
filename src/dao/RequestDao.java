package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import db.Keys;
import db.Request;
import db.User;

public class RequestDao {
	public static void sendRequest(Request r)
	{
			Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			t.begin();
			session.save(r);			
			t.commit();
			session.close();
	}
	public static Request getRequest(String receiver,String sender) throws NullPointerException
	{
			Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			Request r=null;
			Keys k=new Keys(receiver,sender);
			t.begin();
			
			r=(Request)session.get(Request.class,k);
			t.commit();
			session.close();
			return r;

	}
	public static List getRequests(String receiver)
	{
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		Criteria cr=session.createCriteria(Request.class);
		cr.add(Restrictions.eq("key.receiver",receiver));
		List list=cr.list();
		
		t.commit();
		session.close();
		return list;
	}
	public static void handleRequest(String sender,String receiver,boolean accept) {
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Keys key = new Keys(receiver,sender);
		Request r = (Request)session.get(Request.class, key);
		if(accept) { 
			r.setState(1);
			session.update(r);
		} else {
			session.delete(r);
		}
		t.commit();
		session.close();
	}
	public static List getFriendList(String email){
		Session sess = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
    	Transaction t = sess.beginTransaction();
    	t.begin();
    	
    	Criteria criteria = sess.createCriteria(Request.class);
    	criteria.add(Restrictions.and(Restrictions.or(Restrictions.eq("key.sender",email),Restrictions.eq("key.receiver",email)),Restrictions.eq("state",1)));
    	List list = criteria.list();
    	
    	t.commit();
    	sess.close();
		return list;
		
	}
	
		
}


