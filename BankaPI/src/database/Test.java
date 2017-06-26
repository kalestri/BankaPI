package database;


import java.util.Date;
import java.util.Iterator;
import java.util.List;






import model.Drzava;
import model.RacuniPravnihLica;

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
					buildSessionFactory();
			}catch(Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
			}
			
			
			Test t =  new Test();
			
		
			Drzava d = new Drzava();
			d.setNazivDrzave("Srbijaaa");
			d.setSifraDrzave(1);
			
			t.addDrzava(d);
			//t.deleteDrzava(1);
			t.listUsers();
			//t.deleteDrzava(2);
			//t.listUsers();
		}
		   public Integer addDrzava(Drzava drzava){
			   Session session = factory.openSession();
			   Transaction tx = null;
			   Integer sifraDr=null;
			   
			   try{
			         tx = session.beginTransaction();
			         Drzava dr = new Drzava();
			         dr.setSifraDrzave(drzava.getSifraDrzave());
			         dr.setNazivDrzave(drzava.getNazivDrzave());
			         sifraDr = (Integer) session.save(dr); 
			         tx.commit();
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }
			      return sifraDr;
			   
		   }
		
		 
		 public void listUsers(){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         List users = session.createQuery("FROM Drzava").list(); 
		         for (Iterator iterator = 
		                           users.iterator(); iterator.hasNext();){
		            Drzava dr  = (Drzava) iterator.next(); 
		            System.out.print("Sifra Drzave: " + dr.getSifraDrzave() + "Naziv: "+ dr.getNazivDrzave()); 
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
		 
//		 public Integer addUser(String username){
//	      Session session = factory.openSession();
//	      Transaction tx = null;
//	      Integer userID = null;
//	      try{
//	         tx = session.beginTransaction();
//	         Users user = new Users();
//	         user.setUsername(username);
//	         userID = (Integer) session.save(user); 
//	         tx.commit();
//	      }catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      }finally {
//	         session.close(); 
//	      }
//	      return userID;
//	   }
		 public void deleteDrzava(Integer sifra){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         List drzave = session.createQuery("FROM Drzava").list(); 
		         for (Iterator iterator = 
		                           drzave.iterator(); iterator.hasNext();){
		            Drzava dr  = (Drzava) iterator.next(); 
		            if(dr.getSifraDrzave().equals(sifra)){
		            	session.delete(dr); 
		            }
		            
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
