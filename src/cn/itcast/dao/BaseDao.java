package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增
	void save(T t);
	//删
	void delete(T t);
	//删
	void delete(Serializable id);
	//改
	void update(T t);
	//根据id查询
	T getById(Serializable id);
	//查询符合条件到总记录数
	Integer getTotalCount(DetachedCriteria dc);
	//查询分页列表数据
	List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);

}
