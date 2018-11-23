package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.SaleVisit;
import cn.itcast.domain.User;
import cn.itcast.service.SaleVisitService;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit = new SaleVisit();

	private SaleVisitService svs;

	/**
	 * 添加客户拜访记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {

		// 1.取出登录用户，放入SaleVisit实体表达关系
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		// 2.调用Service保存客户拜访记录
		// 加上这个if的原因是这样的，因为我们的SaleVisit的id默认是 "" 在添加记录的时候，回去执行
		// update语句，把id设置为null,那么它就回去执行 save了
		if (saleVisit.getVisit_id() == null || saleVisit.getVisit_id().trim().equals("")) {
			saleVisit.setVisit_id(null);
		}
		svs.save(saleVisit);
		// 3.重定向到拜访记录列表Action
		return "toList";
	}

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}

	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}

}
