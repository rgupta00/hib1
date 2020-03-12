package com.demo;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = null;
		try {
			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

			Session session1 = factory.openSession();
			Customer customer1 = (Customer)
					session1.get(Customer.class, 1);
			
			System.out.println(customer1);
			try{
				Thread.sleep(9000);
			}catch(InterruptedException ex){
				
			}
			session1.refresh(customer1);
			System.out.println(customer1);
			

		} finally {
			if (factory != null)
				factory.close();
		}
	}
}
