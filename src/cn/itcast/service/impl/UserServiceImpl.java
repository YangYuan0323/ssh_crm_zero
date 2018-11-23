package cn.itcast.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {
	
	private UserDao ud;

	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU == null) {
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码不正确");
		}
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		//1.调用dao根据注册的登录名获得用户对象
		User existU = ud.getByUserCode(u.getUser_code());
		//2.如果获得到user对象，用户名已经存在，抛出异常
		if(existU != null) {
			throw new RuntimeException("用户名已经存在");
		}
		//3.调用dao执行保存
		ud.save(u);
		
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}


	
	
	
}
