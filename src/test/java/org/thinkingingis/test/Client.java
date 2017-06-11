package org.thinkingingis.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thinkingingis.web.model.User;

public class Client {
	public static void main(String[] args) {
		//读取配置文件
		Configuration cfg = new Configuration().configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = null;
		try{
			session = factory.openSession();
			//开启事务
			session.beginTransaction();
			
			User user = new User();
			user.setUsername("ok");
			user.setPassword("116");
			user.setAddress("tianchao");
			user.setEmail("116@net.com");
			user.setPhone("8860");
			
			session.save(user);
			//提交事务
			session.getTransaction().commit();
			System.out.println("创建成功！");
		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					//关闭session
					session.close();
				}
			}
			System.exit(0);
		}
	}
}