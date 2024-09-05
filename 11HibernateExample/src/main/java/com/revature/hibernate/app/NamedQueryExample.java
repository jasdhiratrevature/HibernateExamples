package com.revature.hibernate.app;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.hibernate.model.Student;
import com.revature.hibernate.utils.MyHibernateUtil;

public class NamedQueryExample {
public static void main(String[] args) {
	
	Session session=MyHibernateUtil.getSessionFactory().openSession();
	
	//Query stuQuery=session.createQuery("from Student s");
	Query stuQuery=session.getNamedQuery("getAllStudent");
	List<Student> sList=stuQuery.getResultList();
	for(Student s:sList)
		System.out.println(s);
	
	Query oneStudent=session.getNamedQuery("getStudentById");
	oneStudent.setParameter("s_id", 6);
	List<Student> oList=oneStudent.getResultList();
	for(Student s:oList)
		System.out.println(s);
	session.close();
	
}
}
