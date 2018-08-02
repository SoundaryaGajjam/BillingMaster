package com.scp.pojos;

public class ProductPojo {
	private int proudtId;
	private String productName;
	private double availableQty;
	private double productPrice;
	public ProductPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductPojo(String productName, double availableQty, double productPrice) {
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
	@Override
	public String toString() {
		return "\nProduct [proudtId=" + proudtId + ", productName=" + productName + ", quantity=" + availableQty
				+ ", productPrice=" + productPrice + "]";
	}
	
}
