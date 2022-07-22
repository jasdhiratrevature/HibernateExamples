package com.revature.hibernate.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.model.Student;
import com.revature.hibernate.utils.MyHibernateUtil;

public class AnnotationExample {
public static void main(String[] args) {
	Session session=MyHibernateUtil.getSessionFactory().openSession();
	Transaction tx=session.beginTransaction();
	Student s=new Student( "JEM", "Hibernate 222");
	session.save(s);
	tx.commit();
	
}
}
