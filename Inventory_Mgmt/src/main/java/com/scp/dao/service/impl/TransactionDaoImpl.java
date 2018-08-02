package com.scp.dao.service.impl;

import com.scp.dao.services.TransactionDaoService;
import com.scp.generic.GenericClass;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.TransactionPojo;

public class TransactionDaoImpl implements TransactionDaoService{
	GenericClass genObj=new GenericClass();
	@Override
	public boolean addTransactionDao(TransactionPojo tran) {
		genObj.saveObject(Mapping.mapPojoToEntity(tran));
		return true;
	}

}
