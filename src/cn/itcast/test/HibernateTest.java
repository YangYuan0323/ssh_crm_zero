package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

/**
 * 测试hibernate架构
 * 
 * @author yangyuan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name = "sessionFactory")
	private SessionFactory sf;

	@Test
	public void fun1() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setUser_code("tom");
		user.setUser_name("汤姆");
		user.setUser_password("1234");

		session.save(user);
		tx.commit();
		session.close();
		sf.close();

	}

	@Test
	public void fun2() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setUser_code("jerrk");
		user.setUser_name("杰克2");
		user.setUser_password("12334");

		session.save(user);
		tx.commit();
		session.close();

	}

	@Resource(name = "userDao")
	private UserDao ud;

	@Test
	// 测试Dao Hibernate模板
	public void fun3() {

		User u = ud.getByUserCode("tom");

		System.out.println("u:  " + u);
	}

	@Resource(name = "userService")
	private UserService us;
	@Test
	// 测试aop事务
	public void fun4() {
		User u = new User();
		u.setUser_code("lucy");
		u.setUser_name("露西");
		u.setUser_password("1234");

		us.saveUser(u);
	}

}
