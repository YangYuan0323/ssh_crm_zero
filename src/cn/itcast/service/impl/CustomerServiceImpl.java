package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		
		//2.创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.调用dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		//4.将分页列表数据放入pagebean中，并返回
		pb.setList(list);
		return pb;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
