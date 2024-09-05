package com.revature.hib.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/forHibernate");
				settings.put(Environment.JAKARTA_JDBC_USER, "root");
				settings.put(Environment.JAKARTA_JDBC_PASSWORD, "admin@123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);

				/* Class Mapping */

				configuration.addAnnotatedClass(com.revature.hib.example.inheritance.Insurance.class);
				configuration.addAnnotatedClass(com.revature.hib.example.inheritance.CarInsurance.class);
				configuration.addAnnotatedClass(com.revature.hib.example.inheritance.HomeInsurance.class);

				

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
