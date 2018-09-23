package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0) {
			Long count = (Long) list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

}
