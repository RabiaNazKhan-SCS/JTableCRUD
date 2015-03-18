package com.sapphire.experimentshibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerDAO {

	private String customerId;
	private String customerName;
	private String customerEmail;
	private static SessionFactory sessionfactory=null;
	

	//singleton
	public static SessionFactory getSessionFactory(){
		if(sessionfactory==null){
			sessionfactory=new AnnotationConfiguration().configure().buildSessionFactory();
		}
		return sessionfactory;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Customer> SelectAll(){
		
		sessionfactory=getSessionFactory();
		Transaction transaction=null;
		List<Customer> customerList=new ArrayList<Customer>();
		
		try{
			
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			customerList=session.createQuery("from Customer").list();
			transaction.commit();
			
		}catch(HibernateException e){
		
			System.out.println("Exception in Select All");
			transaction.rollback();
		}
		
		return customerList;
		
	}
	
}
