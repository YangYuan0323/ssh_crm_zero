package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		//1.调用service执行登录逻辑
		User u = userService.getUserByCodePassword(user);
		//2.将返回的user对象放入sesssion域
		ActionContext.getContext().getSession().put("user", u);
		//3.重定向到首页
		return "toHome";
	}
	public String regist() throws Exception {
		try {
			//1.调用service保存注册用户
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		
		//2.重定向到登录页面
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}
	
	
	
}	
