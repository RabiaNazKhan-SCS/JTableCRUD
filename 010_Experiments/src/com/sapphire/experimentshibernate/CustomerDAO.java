package com.sapphire.experimentshibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	public static void delete(int customerId){
		sessionfactory=getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			//Customer customer=(Customer)session.get(Customer.class, customerId);
			Query query=session.createQuery("delete from Customer c where c.customerId=:customerId");
			query.setParameter("customerId",customerId);
			
			//System.out.println(customer);
			//session.delete(customer);
			transaction.commit();
			System.out.println("Record is deleted");
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
			System.out.println("Exception in delete method, transaction is rolled back");
		}
	}
	
	public static void create(String customerName,String customerEmail){
		sessionfactory=getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Customer customer=new Customer();
			customer.setCustomerName(customerName);
			customer.setCustomerEmail(customerEmail);
			session.save(customer);
			transaction.commit();
			System.out.println("Record is Saved");
			
		}catch(HibernateException e){
			System.out.println("Exception in save method, Transaction is rolled back");
			e.printStackTrace();
			transaction.rollback();
			
		}
	}

	public static void update(int customerId,String customerName,String customerEmail){
		sessionfactory=getSessionFactory();
		Transaction transaction=null;
		try{
			Session session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Customer customer=(Customer)session.get(Customer.class, customerId);
			customer.setCustomerName(customerName);
			customer.setCustomerEmail(customerEmail);
			session.update(customer);
			transaction.commit();
		}catch(HibernateException e){
			System.out.println("Exception in updation, Transaction is rolled back");
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
