package com.scp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="TransactionInfo")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq_gen2")
	@SequenceGenerator(name="my_seq_gen2", sequenceName="trans_seq",allocationSize=1)
	private int tansId;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER,targetEntity=BillEntity.class)
	private BillEntity billId;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ProductEntity> product;
	@ElementCollection(targetClass=Double.class)
	private List<Double> qty;
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionEntity(BillEntity billId, List<ProductEntity> product, List<Double> qty) {
		super();
		//this.tansId = tansId;
		this.billId = billId;
		this.product = product;
		this.qty = qty;
	}
	public int getTansId() {
		return tansId;
	}
	public void setTansId(int tansId) {
		this.tansId = tansId;
	}
	public BillEntity getBillId() {
		return billId;
	}
	public void setBillId(BillEntity billId) {
		this.billId = billId;
	}
	public List<ProductEntity> getProduct() {
		return product;
	}
	public void setProduct(List<ProductEntity> product) {
		this.product = product;
	}
	public List<Double> getQty() {
		return qty;
	}
	public void setQty(List<Double> qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "\nTransactionEntity [tansId=" + tansId + ", billId=" + billId + ", product=" + product + ", qty=" + qty
				+ "]";
	}
	
	
	
}
