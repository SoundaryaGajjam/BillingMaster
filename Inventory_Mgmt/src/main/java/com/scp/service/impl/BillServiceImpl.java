package com.scp.service.impl;

import com.scp.dao.service.impl.BillDaoImpl;

import com.scp.dao.services.BillDaoService;
import com.scp.entities.BillEntity;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.BillPojo;
import com.scp.services.BillService;

public class BillServiceImpl implements BillService{

	BillDaoService service=new BillDaoImpl(); 
	@Override
	public boolean addBill(BillPojo bill) {
		
		/*BillEntity b=((BillEntity)Mapping.mapPojoToEntity(bill) );
		b.setTransaction(Mapping.mapPojoToEntity(bill.getTransaction()));*/
		
		BillEntity b=new BillEntity();
		b.setCustomer(Mapping.mapPojoToEntity(bill.getCustomer()));
		b.setTransaction(Mapping.mapPojoToEntity(bill.getTransaction()));
		b.setTotalAmount(bill.getTotalAmount());
		
		service.addBillDao(b);
		return true;
	}

}
