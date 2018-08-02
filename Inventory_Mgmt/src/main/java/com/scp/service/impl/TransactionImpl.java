package com.scp.service.impl;

import com.scp.dao.service.impl.TransactionDaoImpl;
import com.scp.dao.services.TransactionDaoService;
import com.scp.pojos.TransactionPojo;
import com.scp.services.TransactionService;

public class TransactionImpl implements TransactionService{
	TransactionDaoService service=new TransactionDaoImpl();
	@Override
	public boolean addTransaction(TransactionPojo tran) {
		service.addTransactionDao(tran);
		return true;
	}

}
