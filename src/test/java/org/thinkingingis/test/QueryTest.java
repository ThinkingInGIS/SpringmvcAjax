package org.thinkingingis.test;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thinkingingis.web.model.User;

public class QueryTest {
	public static void main(String[] args) {  
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = null;
		session = factory.openSession();
		session.beginTransaction();
		String hql=" from User where username=?";
        Query query= session.createQuery(hql);  
        query.setString(0, "me");  
        ArrayList<User> list=  ((ArrayList<User>) query.list());
        //list为查询的结果
        System.out.println(list.get(0).getPhone());
    }
}
