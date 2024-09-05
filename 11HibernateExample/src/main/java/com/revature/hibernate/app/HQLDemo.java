package com.revature.hibernate.app;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.hibernate.model.Student;
import com.revature.hibernate.utils.MyHibernateUtil;

public class HQLDemo {
public static void main(String[] args) {
	Session session=MyHibernateUtil.getSessionFactory().openSession();
	
	TypedQuery<Student> tq1=session.createQuery("from Student where id="+6,Student.class);
	List<Student> sList=tq1.getResultList();
	for(Student s:sList)
		System.out.println(s);
	session.close();
	
	Session session2=MyHibernateUtil.getSessionFactory().openSession();
	Transaction updateTx=session2.beginTransaction();
	Query updateQuery=session2.createQuery("Update Student set course =:c_name where id=:s_id");
	updateQuery.setParameter("c_name", "HQL");
	updateQuery.setParameter("s_id", 7);
	int res=updateQuery.executeUpdate();
	updateTx.commit();
	session2.close();
	
}
}
