package com.scp.mapping.pojo_entity;

import java.util.ArrayList;
import java.util.List;

import com.scp.entities.AdminEntity;
import com.scp.entities.BillEntity;
import com.scp.entities.CustomerEntity;
import com.scp.entities.ProductEntity;
import com.scp.entities.TransactionEntity;
import com.scp.pojos.AdminPojo;
import com.scp.pojos.BillPojo;
import com.scp.pojos.CustomerPojo;
import com.scp.pojos.ProductPojo;
import com.scp.pojos.TransactionPojo;

public class Mapping {

	public static <T, F> F mapPojoToEntity(T Obj) {
		System.out.println("mapping pojo to entity");
		if (Obj instanceof CustomerPojo) {

			CustomerPojo cust = (CustomerPojo) Obj;
			if (null == cust)
				return null;
			CustomerEntity entity = new CustomerEntity();
			entity.setCustId(cust.getCustId());
			entity.setCustName(cust.getCustName());
			entity.setCustBalance(cust.getCustBalance());

			return (F) entity;
		} else if (Obj instanceof ProductPojo) {

			ProductPojo prod = (ProductPojo) Obj;
			if (null == prod)
				return null;
			ProductEntity entity = new ProductEntity();
			entity.setProudtId(prod.getProudtId());
			entity.setProductName(prod.getProductName());
			entity.setAvailableQty((prod.getAvailableQty()));
			entity.setProductPrice(prod.getProductPrice());

			return (F) entity;
		} else if (Obj instanceof AdminPojo) {
			AdminPojo admin = (AdminPojo) Obj;
			if (null == admin)
				return null;
			AdminEntity entity = new AdminEntity();
			entity.setAdminId(admin.getAdminId());
			entity.setUserName(admin.getUserName());
			entity.setPassword(admin.getPassword());
			return (F) entity;
		} else if (Obj instanceof TransactionPojo) {
			TransactionPojo tran = (TransactionPojo) Obj;
			if (null == tran)
				return null;
			TransactionEntity entity = new TransactionEntity();
			//entity.setTansId(tran.getTansId());
			entity.setBillId(Mapping.mapEntityToPojo(tran.getBillId()));
			entity.setProduct(Mapping.mapEntityToPojo(tran.getProduct()));
			entity.setQty(tran.getQty());
			return (F) entity;

		} 
		else if (Obj instanceof BillPojo) {
			BillPojo bill = (BillPojo) Obj;
			if (null == bill)
				return null;
			BillEntity entity = new BillEntity();
			//entity.setBillId(bill.getBillId());
			entity.setCustomer(Mapping.mapPojoToEntity(bill.getCustomer()));
			entity.setTransaction(Mapping.mapPojoToEntity(bill.getTransaction()));
			entity.setTotalAmount(bill.getTotalAmount());
			return (F) entity;
		}

		return null;

	}

	public static <T, F> F mapEntityToPojo(T Obj) {
		System.out.println("mapping entity to pojo");
		if (Obj instanceof CustomerEntity) {
			CustomerEntity cust = (CustomerEntity) Obj;

			if (null == cust)
				return null;
			CustomerPojo pojo = new CustomerPojo();
			pojo.setCustId(cust.getCustId());
			pojo.setCustName(cust.getCustName());
			pojo.setCustBalance(cust.getCustBalance());
			// System.out.println(pojo);
			return (F) pojo;
		}

		else if (Obj instanceof ProductEntity) {

			ProductEntity prod = (ProductEntity) Obj;

			if (null == Obj)
				return null;
			ProductPojo pojo = new ProductPojo();
			pojo.setProudtId(prod.getProudtId());
			pojo.setProductName(prod.getProductName());
			pojo.setAvailableQty((prod.getAvailableQty()));
			pojo.setProductPrice(prod.getProductPrice());

			// System.out.println(pojo);
			return (F) pojo;
		}

		else if (Obj instanceof AdminEntity) {

			AdminEntity admin = (AdminEntity) Obj;

			if (null == Obj)
				return null;
			AdminPojo pojo = new AdminPojo();
			pojo.setAdminId(admin.getAdminId());
			pojo.setUserName(admin.getUserName());
			pojo.setPassword(admin.getPassword());

			// System.out.println(pojo);
			return (F) pojo;
		} else if (Obj instanceof TransactionEntity) {
			TransactionEntity tran = (TransactionEntity) Obj;
			if (null == Obj)
				return null;
			TransactionPojo pojo = new TransactionPojo();
			//pojo.setTansId(tran.getTansId());
			pojo.setBillId(Mapping.mapPojoToEntity(tran.getBillId()));
			pojo.setProduct(Mapping.mapPojoToEntity(tran.getProduct()));
			pojo.setQty(tran.getQty());
			return (F) pojo;
		} 
		else if (Obj instanceof BillEntity) {
			BillEntity bill = (BillEntity) Obj;
			if (null == Obj)
				return null;
			BillPojo pojo = new BillPojo();
			//pojo.setBillId(bill.getBillId());
			pojo.setCustomer(Mapping.mapPojoToEntity(bill.getCustomer()));
			pojo.setTransaction(Mapping.mapEntityToPojo(bill.getTransaction()));
			pojo.setTotalAmount(bill.getTotalAmount());
			return (F) pojo;
		}
		return null;
	}

	public static <T> List<T> mapListOfEntitiestoListOfPojos(List list) {
		List<T> list1 = new ArrayList<>();

		System.out.println("mapping list of entities to list of pojos");
		if (null == list || list.isEmpty())
			return null;
		for (Object item : list) {
			list1.add(mapEntityToPojo((T) item));
		}
		// System.out.println(list1);
		return list1;
	}
}
