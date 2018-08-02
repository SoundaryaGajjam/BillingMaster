package com.scp.pojos;

public class CustomerPojo {

	private int custId;
	private String custName;
	private double custBalance;
	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerPojo( String custName, double custBalance) {
		super();
		//this.custId = custId;
		this.custName = custName;
		this.custBalance = custBalance;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	@Override
	public String toString() {
		return "\nCustomerPojo [custId=" + custId + ", custName=" + custName + ", custBalance=" + custBalance + "]";
	}

	
}
