package com.scp.pojos;

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.scp.entities.CustomerEntity;
import com.scp.entities.TransactionEntity;

public class BillPojo {
	
	private int billId;
	private TransactionPojo transaction;
	private CustomerPojo customer;
	private double totalAmount;
	
	public BillPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillPojo(TransactionPojo transaction, CustomerPojo customer, double totalAmount) {
		super();
		this.transaction = transaction;
		this.customer = customer;
		this.totalAmount = totalAmount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public TransactionPojo getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionPojo transaction) {
		this.transaction = transaction;
	}

	public CustomerPojo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPojo customer) {
		this.customer = customer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "\nBillPojo [billId=" + billId + ", transaction=" + transaction + ", customer=" + customer
				+ ", totalAmount=" + totalAmount + "]";
	}

	
}
