package com.scp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_gen4")
	@SequenceGenerator(name="my_seq_gen4", sequenceName="product_seq",allocationSize=1)
	private int proudtId;
	private String productName;
	private double availableQty;
	private double productPrice;
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductEntity(String productName, double availableQty, double productPrice) {
		super();
		//this.proudtId = proudtId;
		this.productName = productName;
		this.availableQty = availableQty;
		this.productPrice = productPrice;
	}
	public int getProudtId() {
		return proudtId;
	}
	public void setProudtId(int proudtId) {
		this.proudtId = proudtId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(double availableQty) {
		this.availableQty = availableQty;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
