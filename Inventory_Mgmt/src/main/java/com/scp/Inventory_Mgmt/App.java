package com.scp.Inventory_Mgmt;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.entities.AdminEntity;
import com.scp.pojos.AdminPojo;
import com.scp.service.impl.AdminUserImpl;
import com.scp.services.AdminUserService;
import com.scp.util.BillUtil;
import com.scp.util.CustomerUtil;
import com.scp.util.HibernateUtil;
import com.scp.util.ProductUtil;

public class App 
{
    public static void main( String[] args )
    {
    	int opt;
        System.out.println( "Hello World!" );
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter UserName for authentication : ");
        String userName=sc.next();
        System.out.println("Enter password : ");
        String password=sc.next();
        
       AdminPojo user1=new AdminPojo(userName, password);
        AdminUserService adminService=new AdminUserImpl();
        adminService.addUser(user1);
        boolean flag=verifyUser(userName,password);
        System.out.println(flag);
        if(flag){
        	do{
        		System.out.println("1.Customer\n2.Product\n3Make Bill");
        		System.out.println("Enter your choice : ");
        		int ch=sc.nextInt();
        		switch (ch) {
				case 1:
					CustomerUtil.customerInfo();
					break;
				case 2: 
					ProductUtil.productInfo();
					break;
				case 3:
					BillUtil.billInfo();
					break;
				default:System.out.println("Ooops...Invalid choice ...");
				break;
			}
			System.out.println("Do u want to Continue the app ?...Press 1 : ");
			  opt=sc.nextInt();
			
		}while(1==opt);
        }
        
    }

	private static boolean verifyUser(String userName, String password) {
		SessionFactory sFactory=HibernateUtil.getSessionFactory();
		Session s1=sFactory.openSession();
		Transaction tr1=s1.beginTransaction();
		try{
		AdminEntity entity=s1.get(AdminEntity.class,1);
		if(null==userName || null==password)
			throw new Exception("UserName can not be null");
		if(entity.getUserName().equals(userName)&&entity.getPassword().equals(password))
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
}
