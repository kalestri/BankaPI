package model.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.dao.GenericDao;

public abstract class GenericDaoImpl<T, PK extends Serializable> 
		implements GenericDao<T, PK>{
	
	protected Class<T> entityClass;
	
    @PersistenceContext
    protected EntityManager entityManager;
    
    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
             .getActualTypeArguments()[0];
    }


	@Override
	public T create(T t) {
		 this.entityManager.persist(t);
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
