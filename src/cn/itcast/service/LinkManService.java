package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;
import cn.itcast.utils.PageBean;
import cn.itcast.web.action.LinkManAction;

public interface LinkManService {

	//保存联系人
	void save(LinkMan linkMan);
	//联系人列表
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
