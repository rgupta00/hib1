package com.demo.cpk;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory=null;
		try{
		factory= new AnnotationConfiguration()
		.configure().buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx= session.getTransaction();
	
		//Customer customer=(Customer) session.load(Customer.class, 1);
		
		//session.close();
		
		//System.out.println(customer);
		
		try{
			CustomerPk pk=new CustomerPk(1219, "AZ123");
			tx.begin();
			Customer customer2=
					new Customer
					(pk, "amit", "delhi", new Date(), "demo123");
			  session.save(customer2);
			
/*
			Customer customer=
					(Customer) 
					session
					.get(Customer.class, new CustomerPk(121, "AZ123"));
			System.out.println(customer);*/
			tx.commit();
		}catch(HibernateException ex){
			tx.rollback();
		}
		
		}finally{
			if(factory!=null)
				factory.close();
		}
	}
}
