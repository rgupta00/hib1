package com.demo.one2one.uni;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		SessionFactory factory = null;
		try {
			factory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

			Session session = factory.openSession();

			Transaction tx = session.getTransaction();

			try {
				tx.begin();

				List<Parking> parkings=
						session.createQuery
						("select p from Parking p join fetch p.employee Employee")
						.list();
				
				session.close();
				
				System.out.println("*******************");
				for(Parking p: parkings){
					System.out.println(p);
					System.out.println("--------------------------");
					System.out.println(p.getEmployee().getName());
				}
				

				/*Employee employee=new Employee();
				employee.setName("suman");
				
				Parking parking=new Parking();
				parking.setName("H1");
				parking.setEmployee(employee);
				session.save(parking);
				session.save(employee);
				
				Employee employee2=new Employee();
				employee2.setName("gunika");
				
				Parking parking2=new Parking();
				parking2.setName("L2");
				parking2.setEmployee(employee2);
				session.save(parking2);
				session.save(employee2);
				*/
				
				tx.commit();
			} catch (HibernateException ex) {
				System.out.println(ex);
				tx.rollback();
			}

		} finally {
			if (factory != null)
				factory.close();
		}
	}
}
