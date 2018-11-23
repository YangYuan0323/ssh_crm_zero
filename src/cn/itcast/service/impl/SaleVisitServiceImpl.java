package cn.itcast.service.impl;

import cn.itcast.dao.SaleVisitDao;
import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {
	
	private SaleVisitDao svd;

	@Override
	public void save(SaleVisit saleVisit) {
		svd.saveOrUpdate(saleVisit);

	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}
	
	

}
