package com.scp.util;

import java.util.List;
import java.util.Scanner;

import com.scp.pojos.CustomerPojo;
import com.scp.pojos.ProductPojo;
import com.scp.service.impl.CustomerImpl;
import com.scp.service.impl.ProductImpl;
import com.scp.services.CustomerService;
import com.scp.services.ProductService;

public class ProductUtil {
	static Scanner sc=new Scanner(System.in);
	public static void productInfo(){
		String opt=null;
		ProductService prodService=new ProductImpl();
		ProductPojo prod=null;
		List<ProductPojo>listOfprod;
		int prodId;
		do{
			System.out.println("1.Add Product\n2.Update Product\n3.Get Product\n4.Get all product info\n5.Delete product");
			System.out.println("Enter your choice : ");
			int ch=sc.nextInt();
			switch (ch) {
			case 1:
				prod=inputFromUser();
				prodService.addProduct(prod);
			    System.out.println("Product added successfully");
				break;
			case 2:
				//listOfprod=prodService.getAllProduct();
		        //System.out.println(listOfprod);
				System.out.println("Enter product id which u want to update : ");
				prodId=sc.nextInt();
				prodService.updateProduct(prodId);
				break;
			case 3:
				System.out.println("Enter product id which u want to get : ");
				prodId=sc.nextInt();
				prod=prodService.getProduct(prodId);
		        System.out.println(prod);
		        break;
			case 4:
				listOfprod=prodService.getAllProduct();
		        System.out.println(listOfprod);
		        break;
			case 5:
				System.out.println("Enter product id which u want to delete : ");
				prodId=sc.nextInt();
				prodService.deleteProduct(prodId);
		        System.out.println("successfully deleted");
		        break;
			default:System.out.println("Ooops...Invalid choice ...");
				break;
			}
			System.out.println("Do u want to continue...Press y : ");
			 opt=sc.next();
			
		}while("y".equalsIgnoreCase(opt));
	}
	private static ProductPojo inputFromUser() {

		System.out.println("Enter Product Name : ");
		String prodName=sc.next();
		System.out.println("Enter quantity : ");
		double avaliableQty=sc.nextDouble();
		System.out.println("Enter price : ");
		double price=sc.nextDouble();
		return new ProductPojo(prodName, avaliableQty, price);
	}
}
