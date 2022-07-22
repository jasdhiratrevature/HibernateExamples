package com.revature.hib.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainApp3 {
	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		
	       if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
               
            }
        }
      
    }
	       
	       Session session = sessionFactory.openSession();
			
			  Transaction transaction = session.beginTransaction(); Student s=new
			  Student("Jasdhir","S","js@vw.com"); session.save(s); transaction.commit();
			 
	       
			/*
			 * Student s=session.load(Student.class, new Integer(1)); System.out.println(s);
			 */
	        
	       
			/*
			 * Student s=session.load(Student.class, new Integer(2)); Transaction
			 * transaction=session.beginTransaction(); s.setFirstName("Ben");
			 * session.saveOrUpdate(s); transaction.commit();
			 */


			/*
			 * Student s=session.load(Student.class, new Integer(2)); Transaction
			 * tx=session.beginTransaction(); session.delete(s); tx.commit();
			 */
	       

	       
}
}













