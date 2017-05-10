package model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import model.dao.GenericDao;

public abstract class GenericDaoImpl<T, PK extends Serializable> 
		implements GenericDao<T, PK>{
	
	protected Class<T> entityClass;
	
	private static SessionFactory factory;
	
    @PersistenceContext
    protected EntityManager entityManager;
    
    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
             .getActualTypeArguments()[0];
        
        try{
			factory = new AnnotationConfiguration().
					configure().addPackage("model").
				buildSessionFactory();
		}catch(Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
        
    }


	@Override
	public T create(T t) {
		 this.entityManager.persist(t);
	     return t;
	}
	
	public T commit(T t){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
	         tx = session.beginTransaction();
	         session.save(t);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return t;
	
	}

	@Override
	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		 t = this.entityManager.merge(t);
	     this.entityManager.remove(t);
		
	}

}
