package com.scp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.entities.CustomerEntity;
import com.scp.entities.ProductEntity;
import com.scp.entities.TransactionEntity;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.BillPojo;
import com.scp.pojos.CustomerPojo;
import com.scp.pojos.ProductPojo;
import com.scp.pojos.TransactionPojo;
import com.scp.service.impl.BillServiceImpl;
import com.scp.service.impl.CustomerImpl;
import com.scp.service.impl.ProductImpl;
import com.scp.services.BillService;
import com.scp.services.CustomerService;
import com.scp.services.ProductService;

public class BillUtil {

	public static void billInfo() {
		Scanner sc=new Scanner(System.in);
		CustomerService custService=new CustomerImpl();
		CustomerPojo cust=null;
		List<CustomerPojo>listOfcust;
		ProductService prodService=new ProductImpl();
		ProductPojo prod=null;
		List<ProductPojo>listOfprod;
		BillService billService=new BillServiceImpl();
		List<ProductPojo>listOfprod1=new ArrayList<>();
		List<Double>prodQty=new ArrayList<>();
		int prodId;
		String opt=null;
		double qty;
		double totalAmount=0.0;
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session s1=null;
		Transaction tr1=null;
		
		do{
			System.out.println("1.Add Bill\n2.Update Bill\n3.Get Bill\n4.Get all Bill info\n5.Delete Bill");
			System.out.println("Enter your choice : ");
			int ch=sc.nextInt();
			 s1=sFactory.openSession();
	        tr1=s1.beginTransaction();
	        
	        Session s2=sFactory.openSession();
	        Transaction tr2=s2.beginTransaction();
			switch (ch) {
			case 1:
				listOfcust=custService.getAllCustomer();
		        System.out.println(listOfcust);
		        System.out.println("Enter customer id which u want to make bill : ");
		        int custId=sc.nextInt();
		        cust=custService.getCustomer(custId);
		        listOfprod=prodService.getAllProduct();
		        System.out.println(listOfprod);
		        
		       
		        do{
		        	
		        	s1=sFactory.openSession();
			        tr1=s1.beginTransaction();
		        System.out.println("Enter product id which u want to get : ");
				prodId=sc.nextInt();
				System.out.println("Enter quantity : ");
				qty=sc.nextDouble();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%");
				/*prod=prodService.getProduct(prodId);
				System.out.println("************"+prod);*/
				//ProductEntity prod1=s1.get(ProductEntity.class,1);
				prod=prodService.getProduct(prodId);
				System.out.println("************"+prod);
				if(qty<prod.getAvailableQty()){
					listOfprod1.add(prod);
					prodQty.add(qty);
					prod.setAvailableQty(prod.getAvailableQty()-qty);
			        totalAmount+=qty*prod.getProductPrice();
			        //prodService.addProduct(prod);
			        ProductEntity pe=Mapping.mapPojoToEntity(prod);
			        s1.update(pe);
			        HibernateUtil.FlushNCommit(s1, tr1);
			        
			        cust.setCustBalance(cust.getCustBalance()+totalAmount);
			        CustomerEntity ce = Mapping.mapPojoToEntity(cust);
			       
			        s2.merge(ce);
			        HibernateUtil.FlushNCommit(s2, tr2);
				}
				else{
					System.out.println("Sorry ... Only "+prod.getAvailableQty()+" "+prod.getProductName()+" are avaliable !!!");
				}
				System.out.println("U want to purchase more product ? Press y...");
				opt=sc.next();
		        }while("y".equalsIgnoreCase(opt));
		        
		       // BillPojo b=new BillPojo();
		        BillPojo bp=new BillPojo(null, cust, totalAmount);
		        TransactionPojo t=new TransactionPojo(bp, listOfprod1, prodQty);
		        bp.setTransaction(t);
		      // TransactionPojo t=new TransactionPojo(b, listOfprod1, prodQty);
		      // TransactionEntity te=Mapping.mapPojoToEntity(t);
		      //  s1.save(te);
		       // BillPojo bill=new BillPojo(t,cust,totalAmount);
		      /* b.setCustomer(cust);
		       b.setTransaction(t);
		       b.setTotalAmount(totalAmount);*/
		        billService.addBill(bp);
		        System.out.println("Successs;;;;;;;;;;;;;");
				break;
			default:System.out.println("Ooops...Invalid choice ...");
			break;
		}
		System.out.println("Do u want to continue...Press y : ");
		 opt=sc.next();
		
	}while("y".equalsIgnoreCase(opt));
		
	}

}
