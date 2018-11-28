package com.managementsystem.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<PK extends Serializable, T>{
	/**
	 * 根据ID获取对象(对象不存在则返回null)
	 * @param id
	 * @return
	 */
	T getById(PK id);
	/**
	 * 根据ID获取对象(对象不存在则报异常)
	 * @param id
	 * @return
	 */
	T loadById(PK id);
	/**
	 * 获取所有对象
	 * @return
	 */
	List<T> getAll();
	/**
	 * 根据单个字段,字段值获取对应的对象(适用于 where = 的情况)
	 * @param filed
	 * @param value
	 * @return
	 */
}
