package com.scp.util;

import java.util.List;
import java.util.Scanner;

import com.scp.pojos.CustomerPojo;
import com.scp.service.impl.CustomerImpl;
import com.scp.services.CustomerService;

public class CustomerUtil {
	static Scanner sc = new Scanner(System.in);

	public static void customerInfo() {
		String opt = null;
		CustomerService custService = new CustomerImpl();
		CustomerPojo cust = null;
		List<CustomerPojo> listOfcust;
		int custId;
		do {
			System.out.println(
					"1.Add Customer\n2.Update Customer\n3.Get Customer\n4.Get all customer info\n5.Delete Customer");
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				cust = inputFromUser();
				custService.addCustomer(cust);
				System.out.println("Customer Info added successfully");
				break;
			case 2:
				//listOfcust = custService.getAllCustomer();
				//System.out.println(listOfcust);
				System.out.println("Enter customer id which u want to update : ");
				custId = sc.nextInt();
				custService.updateCustomer(custId);
				break;
			case 3:
				System.out.println("Enter customer id which u want to get : ");
				custId = sc.nextInt();
				cust = custService.getCustomer(custId);
				System.out.println(cust);
				break;
			case 4:
				listOfcust = custService.getAllCustomer();
				System.out.println(listOfcust);
				break;
			case 5:
				System.out.println("Enter customer id which u want to delete : ");
				custId = sc.nextInt();
				custService.deleteCustomer(custId);
				System.out.println("successfully deleted");
			default:
				System.out.println("Ooops...Invalid choice ...");
				break;
			}
			System.out.println("Do u want to continue...Press y : ");
			opt = sc.next();

		} while ("y".equalsIgnoreCase(opt));
	}

	private static CustomerPojo inputFromUser() {

		System.out.println("Enter Customer Name : ");
		String custName = sc.next();
		System.out.println("Enter initial balance : ");
		double custBalance = sc.nextDouble();
		return new CustomerPojo(custName, custBalance);
	}
}
