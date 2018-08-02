package com.scp.dao.service.impl;

import com.scp.dao.services.BillDaoService;
import com.scp.entities.BillEntity;
import com.scp.generic.GenericClass;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.BillPojo;

public class BillDaoImpl implements BillDaoService {
	GenericClass genObj=new GenericClass();
	@Override
	public boolean addBillDao(BillEntity bill) {
		genObj.saveObject(bill);
		return true;
	}

}
