package com.revature.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.revature.hibernate.model.Student;
import com.revature.hibernate.utils.MyHibernateUtil;

public class MainApp01 {
	
public static void main(String[] args) {
	 
	  
	  Session session = MyHibernateUtil.getSessionFactory().openSession();
	  // Insert Data
		/*
		 * Student s=new Student(1,"Mike","Project"); Transaction
		 * tx=session.beginTransaction(); session.save(s); tx.commit();
		 */
	  
	  // Read Data
	List<Student> stuList=session.createQuery("from Student s").list();
	
	for(Student s:stuList)
		System.out.println(s.getId() +" - "+s.getName());
	System.out.println("---------------------------------------------");
	
	// Read one Student
	//Student s=session.get(Student.class, 6);
	Student s=session.load(Student.class, 5);
	System.out.println(s);
	//session.close();
	
	// update -  delete an Object
	Student s1=session.load(Student.class, 4);
	Transaction tx2=session.beginTransaction();
	//s1.setCourse("Hibernate");
	//session.update(s1);
	session.delete(s1);
	tx2.commit();
	
	
	
}
}
