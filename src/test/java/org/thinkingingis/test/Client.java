package org.thinkingingis.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thinkingingis.web.model.User;

public class Client {
	public static void main(String[] args) {
		//��ȡ�����ļ�
		Configuration cfg = new Configuration().configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = null;
		try{
			session = factory.openSession();
			//��������
			session.beginTransaction();
			
			User user = new User();
			user.setUsername("ok");
			user.setPassword("116");
			user.setAddress("tianchao");
			user.setEmail("116@net.com");
			user.setPhone("8860");
			
			session.save(user);
			//�ύ����
			session.getTransaction().commit();
			System.out.println("�����ɹ���");
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					//�ر�session
					session.close();
				}
			}
			System.exit(0);
		}
	}
}