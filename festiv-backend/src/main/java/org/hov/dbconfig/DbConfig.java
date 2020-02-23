package org.hov.dbconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hov.model.Item;
import org.hov.model.Order;
import org.hov.model.Payment;
import org.hov.model.Team;
import org.hov.model.User;

public class DbConfig 
{
	public static SessionFactory factory;
	
	static
	{
		loadSessionFactory();
	}
	
	public static void loadSessionFactory()
	{
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Item.class);
		cfg.addAnnotatedClass(Team.class);
		cfg.addAnnotatedClass(Order.class);
		cfg.addAnnotatedClass(Payment.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory();
	}
	
	public static Session getSession()
	{
		return factory.openSession();
	}
}
