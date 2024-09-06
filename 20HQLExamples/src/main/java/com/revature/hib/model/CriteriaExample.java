package com.revature.hib.model;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import com.revature.hib.utils.HibernateUtils;



public class CriteriaExample {
public static void main(String[] args) {
	Transaction transactionOne = null;
	Session session = HibernateUtils.getSessionFactory().openSession();
	CriteriaBuilder cb = session.getCriteriaBuilder();
	CriteriaQuery<Student> cr = cb.createQuery(Student.class);
	Root<Student> root = cr.from(Student.class);
	//Example 1: get all the items.
	//cr.select(root);
	
	// Example 2 : To get student having id greater than / greater than equal to  2:
		//cr.select(root).where(cb.gt(root.get("id"), 2));
	
	// Example 3: using like operator
		//cr.select(root).where(cb.like(root.get("firstName"), "%sd%"));
		
	// Example 4: between operator
	//cr.select(root).where(cb.between(root.get("id"), 1, 2));
		
	//Example 5: To check if the given property is null:
			//cr.select(root).where(cb.isNull(root.get("email")));

	//Example 6: To check if the given property is not null:
	//cr.select(root).where(cb.isNotNull(root.get("email")));
	
	// Example 7: Order by
	//cr.orderBy( cb.desc(root.get("firstName")));
	
	//the Criteria API allows us to easily chain expressions:
		Predicate greaterThanID = cb.gt(root.get("id"), 1);
		Predicate nameItems = cb.like(root.get("firstName"), "%r%");
		/// Items with the above-defined conditions joined with Logical OR:
		cr.select(root).where(cb.or(greaterThanID, nameItems));
		
	
	Query<Student> query = session.createQuery(cr);
	List<Student> results = query.getResultList();
	results.forEach(i->System.out.println(i));
}
}
