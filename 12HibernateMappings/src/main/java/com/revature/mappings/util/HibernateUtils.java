package com.revature.mappings.util;

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
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://jasdhir-rds.cvtq9j4axrge.us-east-1.rds.amazonaws.com:5432/forHibernate");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "postgres!23");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
               settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
				
				 
				/* For 1-1 Mapping */
				
                configuration.addAnnotatedClass(com.revature.mappings.oto.User.class);
                configuration.addAnnotatedClass(com.revature.mappings.oto.UserDetail.class);
                
				 /* For 1-N MApping  */
                configuration.addAnnotatedClass(com.revature.mappings.otm.Department.class);
                configuration.addAnnotatedClass(com.revature.mappings.otm.Employee.class);
                
                
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
