package com.scp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="BillInfo")
public class BillEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_gen1")
	@SequenceGenerator(name="my_seq_gen1", sequenceName="bill_seq",allocationSize=1)
	private int billId;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private TransactionEntity transaction;
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerEntity customer;
	private double totalAmount;
	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillEntity(TransactionEntity transaction, CustomerEntity customer, double totalAmount) {
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
	
	public TransactionEntity getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
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
		return "\nBillEntity [billId=" + billId + ", transaction=" + transaction + ", customer=" + customer
				+ ", totalAmount=" + totalAmount + "]";
	}

	
	
	
}
