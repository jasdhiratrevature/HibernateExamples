package com.revature.hib.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.hib.utils.HibernateUtils;

public class HQLExample {
public static void main(String[] args) {
	// SELECT Query
	String hql = "FROM Student";
	Session session = HibernateUtils.getSessionFactory().openSession();
	List<Student> students = session.createQuery(hql, Student.class).getResultList();
	students.forEach(System.out::println);
	session.close();
	
	// WHERE CLAUSE - using named parameter
	//hql = "FROM Student S WHERE S.firstName = :firstName"; // named parameter
	hql = "FROM Student S WHERE S.firstName = ?1"; // positional parameter
	session = HibernateUtils.getSessionFactory().openSession();
	Query<Student> query = session.createQuery(hql, Student.class);
	//query.setParameter("firstName", "Shrey");
	query.setParameter(1, "Shrey");
	 students = query.getResultList();
	students.forEach(System.out::println);
	session.close();
	
	// ORDER By Clause
	hql = "FROM Student S ORDER BY S.lastName ASC";
	 session = HibernateUtils.getSessionFactory().openSession();
	 students = session.createQuery(hql, Student.class).getResultList();
	students.forEach(System.out::println);
	session.close();
	
	// HQL supports aggregate functions like COUNT, SUM, AVG, MAX, and MIN.
	hql = "SELECT COUNT(S.id) FROM Student S";
	session = HibernateUtils.getSessionFactory().openSession();
	Long count = (Long) session.createQuery(hql).getSingleResult();
	System.out.println("Total Students: " + count);
	session.close();
	
	// Group By and Having
	hql = "SELECT S.lastName, COUNT(S.id) FROM Student S GROUP BY S.lastName HAVING COUNT(S.id) > 1";
	session = HibernateUtils.getSessionFactory().openSession();
	List<Object[]> results = session.createQuery(hql).getResultList();
	for (Object[] result : results) {
	    System.out.println("Last Name: " + result[0] + ", Count: " + result[1]);
	}
	session.close();
	
}
}
