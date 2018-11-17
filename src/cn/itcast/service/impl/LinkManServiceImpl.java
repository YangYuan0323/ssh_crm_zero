package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao lmd;
	

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		
		//2.创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		//3.调用dao查询分页列表数据
		List<LinkMan> list = lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		//4.将分页列表数据放入pagebean中，并返回
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);

	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	
	
	

}
