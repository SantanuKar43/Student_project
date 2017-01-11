package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import db.Status;
import db.User;

public class UserDao {
	public static String register(User u) throws ConstraintViolationException {
		String i="";
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		t.begin();
		i=(String)session.save(u);
		
		t.commit();
		session.close();
		return i;
	}

	public static User getUser(String email) {
		// TODO Auto-generated method stub
		User u = new User();
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		 Criteria criteria = session.createCriteria(User.class);
		 criteria.add(Restrictions.eq("email", email));
		 u = (User) criteria.uniqueResult();
		 if (u!=null) {
			 System.out.println("User found:");
			 System.out.println(u.getEmail() + " - " + u.getName());
		 
		 }
		return u;
	}
	public static void updateProfile(User u) {
		User u1 = new User();
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		u1 = (User)session.get(User.class,u.getEmail());
		u1.setName(u.getName());
		u1.setDob(u.getDob());
		u1.setGender(u.getGender());
		session.update(u1);
		t.commit();
		session.close();
	}
	public static List searchUsers(String name) {
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.ilike("name",name,MatchMode.START));
		List list=cr.list();
		t.commit();
		session.close();
		return list;
	}
	public static void setLike(String receiver,String liker){
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		User u = (User)session.get(User.class,receiver);
		String likes = u.getLikes();
		if(likes==null){
			likes="";
		}
		likes = likes+liker+",";
		u.setLikes(likes);
		session.update(u);
		t.commit();
		session.close();
	}
	public static void unLike(String receiver,String liker){
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		User u = (User)session.get(User.class,receiver);
		String likes = u.getLikes();
		if(likes==null){
			likes="";
		}
		String array_of_likes[] = likes.split(",");
		String temp="";
		for(String s:array_of_likes){
			if(!s.equals(liker)){
				temp = temp+s+",";
			}
		}
		likes = temp;
		u.setLikes(likes);
		session.update(u);
		
		t.commit();
		session.close();
	}
}
