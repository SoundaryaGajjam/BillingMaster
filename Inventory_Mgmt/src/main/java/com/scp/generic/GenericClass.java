package com.scp.generic;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.entities.CustomerEntity;
import com.scp.entities.ProductEntity;
import com.scp.util.HibernateUtil;

public class GenericClass<T, F,P> {
	static SessionFactory sFactory=null;
	static{
		sFactory=HibernateUtil.getSessionFactory();
	}
	Scanner sc=new Scanner(System.in);
	public <T>boolean saveObject(T obj){
		System.out.println("in genric");
		Session s1=sFactory.openSession();
		Transaction tr1=s1.beginTransaction();
		try{
		int id=(int) s1.save(obj);
		HibernateUtil.FlushNCommit(s1, tr1);
		System.out.println("success");
		return id!=0;
		}catch (Exception e) {
			e.printStackTrace();
			tr1.rollback();
		}
		return false;	
	}
	public <T>T getObject(Class T,int id) {
		//System.out.println("get");
		Session s2=sFactory.openSession();
		Transaction tr2=s2.beginTransaction();
		try{
			T obj=(T) s2.get(T, id);
			//HibernateUtil.FlushNCommit(s2, tr2);
			
			return (T)obj;
		}catch (Exception e) {
			tr2.rollback();
		}
		return null;
		
	}
	public boolean deleteObject(Class T,int id) {
		System.out.println("delete");
		Session s1=sFactory.openSession();
		Transaction tr1=s1.beginTransaction();
		F obj=getObject(T, id);
		try{
			s1.delete(obj);
			HibernateUtil.FlushNCommit(s1, tr1);
			
		}catch (Exception e) {
			tr1.rollback();
		}
		return false;
		
	}
		
		public List<F>  getAllObject(Class T) {
			Session s1=sFactory.openSession();
			Transaction tr1=s1.beginTransaction();
			System.out.println("....in getAll.............");
			Criteria cr=s1.createCriteria(T);
			
			return  cr.list();
			
			
		}
		
		public void updateObject(Class T, int id) {
			Session s1=sFactory.openSession();
			Transaction tr1=s1.beginTransaction();
			System.out.println("...In update...");
			
			T obj=getObject(T, id);
			List<T>list=(List<T>) getAllObject(T);
			System.out.println(list);
			if(obj instanceof CustomerEntity){
				System.out.println("Enter balance for updation : ");
				double balance=sc.nextDouble();
				((CustomerEntity) obj).setCustBalance(((CustomerEntity) obj).getCustBalance()+balance);
				s1.update(obj);
				HibernateUtil.FlushNCommit(s1, tr1);
			}
			if(obj instanceof ProductEntity){
				System.out.println("Enter quantity : ");
				int qty=sc.nextInt();
				((ProductEntity) obj).setAvailableQty(((ProductEntity) obj).getAvailableQty()+qty);
				System.out.println("U want to update product price ?  Preass y : ");
				String opt=sc.next();
				if("y".equalsIgnoreCase(opt)){
				System.out.println("Enter price : ");
				double price=sc.nextDouble();
				((ProductEntity) obj).setProductPrice(price);
				}
				s1.update(obj);
				HibernateUtil.FlushNCommit(s1, tr1);
			}
			
		}

		

		
}
