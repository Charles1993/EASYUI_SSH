package com.managementsystem.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
@Repository
public  class BaseDaoImpl<PK extends Serializable, T> implements BaseDao<PK, T> {
	private  Class<T> persistentClass;
	/**
	 * 映射方式找到传递进来类的本质类
	 */
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		
        this.persistentClass = null;  
        Class c = getClass();  
        Type t = c.getGenericSuperclass();  
        if (t instanceof ParameterizedType) {  
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();  
            this.persistentClass = (Class<T>) p[1];  
        }
	}
	
	@Resource
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK id) {
		return (T) getSession().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T loadById(PK id) {
		return (T) getSession().load(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Criteria criteria=createEntityCriteria();
		return (List<T>)criteria.list();
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByFiled(String propertyName, Object value) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq(propertyName, value));
		return (List<T>)criteria.list();
	}
	
}
