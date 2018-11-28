package com.managementsystem.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.dao.BaseDao;


/**
 * 泛型业务类,此时这里不能加@service 这个变量,因为controller层自动注入service对象时不需要生成泛型对象,
 * 又因为集成了此类,故此类下的对应Dao类也需要实现依赖注入,供controller层的实体serivices使用
 * @author cong.liu
 *
 * @param <PK>
 * @param <T>
 */
public class BaseServiceImpl<PK extends Serializable, T> implements BaseService<PK, T>{
	
	@Autowired
	private BaseDao<PK, T> baseDao;
	

//	public BaseDao<PK, T> getBaseDao() {
//		return baseDao;
//	}
//
//	public void setBaseDao(BaseDao<PK, T> baseDao) {
//		this.baseDao = baseDao;
//	}

	@Override
	public T getById(PK id) {
		return baseDao.getById(id);
	}

	@Override
	public T loadById(PK id) {
		return baseDao.loadById(id);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}

}
