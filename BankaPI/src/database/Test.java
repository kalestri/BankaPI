package database;


import java.util.Iterator;
import java.util.List;

import model.Users;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class Test {

		private static SessionFactory factory;
		
		public static void main(String[] args){
			
			try{
				factory = new AnnotationConfiguration().
						configure().addPackage("model").
						addAnnotatedClass(Users.class).buildSessionFactory();
			}catch(Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
			
		}
			  Test t = new Test();
			  
			  Integer empID1 = t.addUser("Novke");
			  Integer empID2 = t.addUser("Sale");
			  
			  t.listUsers();
		     
		}
		
		 public Integer addUser(String username){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer userID = null;
		      try{
		         tx = session.beginTransaction();
		         Users user = new Users();
		         user.setUsername(username);
		         userID = (Integer) session.save(user); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		      return userID;
		   }
		 
		 public void listUsers( ){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         List users = session.createQuery("FROM Users").list(); 
		         for (Iterator iterator = 
		                           users.iterator(); iterator.hasNext();){
		            Users user = (Users) iterator.next(); 
		            System.out.print("Username: " + user.getUsername()); 
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
}
