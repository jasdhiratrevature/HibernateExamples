package com.revature.hibernate.app;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.hibernate.model.Student;
import com.revature.hibernate.utils.MyHibernateUtil;

public class CriteriaExample {
public static void main(String[] args) {
	
	Session session=MyHibernateUtil.getSessionFactory().openSession();
	
	CriteriaBuilder builder=session.getCriteriaBuilder();
	
	CriteriaQuery<Student> stuQuery=builder.createQuery(Student.class);
	
	Root<Student> root=stuQuery.from(Student.class);
	
	stuQuery.select(root).where(builder.like(root.get("name"), "J%"));
	
	List<Student> sList=session.createQuery(stuQuery).getResultList();
	
	for(Student s:sList)
		System.out.println(s);
	
	
	
}
}
