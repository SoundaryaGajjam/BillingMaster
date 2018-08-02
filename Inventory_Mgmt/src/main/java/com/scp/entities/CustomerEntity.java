package com.scp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_gen3")
	@SequenceGenerator(name="my_seq_gen3", sequenceName="customer_seq",allocationSize=1)
	private int custId;
	private String custName;
	private double custBalance;
	/*@OneToOne(cascade=CascadeType.ALL)
	private BillEntity bill;*/
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerEntity(String custName, double custBalance) {
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
		return "\nCustomerEntity [custId=" + custId + ", custName=" + custName + ", custBalance=" + custBalance + "]";
	}
	
	
}
