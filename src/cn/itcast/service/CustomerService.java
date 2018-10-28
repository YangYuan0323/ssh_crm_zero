package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.PageBean;

public interface CustomerService {

	/**
	 * 分页业务方法
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	/**
	 * 保存客户
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * 根据id查询客户
	 * @param cust_id
	 * @return
	 */
	Customer getById(Long cust_id);

}
