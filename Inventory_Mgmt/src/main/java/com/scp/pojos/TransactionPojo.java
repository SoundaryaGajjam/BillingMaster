package com.scp.pojos;

import java.util.List;

import com.scp.entities.BillEntity;
import com.scp.entities.ProductEntity;

public class TransactionPojo {
	private int tansId;
	private BillPojo billId;
	
	private List<ProductPojo> product;
	private List<Double> qty;
	public TransactionPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionPojo(BillPojo billId, List<ProductPojo> product, List<Double> qty) {
		super();
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
	public BillPojo getBillId() {
		return billId;
	}
	public void setBillId(BillPojo billId) {
		this.billId = billId;
	}
	public List<ProductPojo> getProduct() {
		return product;
	}
	public void setProduct(List<ProductPojo> product) {
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
		return "\nTransactionPojo [tansId=" + tansId + ", billId=" + billId + ", product=" + product + ", qty=" + qty
				+ "]";
	}
	
	
	
}
