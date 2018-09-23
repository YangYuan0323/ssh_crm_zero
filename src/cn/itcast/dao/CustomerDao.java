package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	public Integer getTotalCount(DetachedCriteria dc);

	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
