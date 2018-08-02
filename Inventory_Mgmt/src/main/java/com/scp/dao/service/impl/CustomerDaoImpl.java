package com.scp.dao.service.impl;

import java.util.List;

import com.scp.dao.services.CustomerDaoService;
import com.scp.entities.CustomerEntity;
import com.scp.generic.GenericClass;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.CustomerPojo;

public class CustomerDaoImpl implements CustomerDaoService{
	GenericClass genObj=new GenericClass();
	@Override
	public boolean addCustomerDao(CustomerEntity cust) {
		System.out.println("in dao impl");
		genObj.saveObject(cust);
		return true;
	}
	
	@Override
	public CustomerEntity getCustomer(int custId) {
		
		CustomerEntity cust=(CustomerEntity) genObj.getObject(CustomerEntity.class,custId);
		//System.out.println("---"+custPojo);
		return cust;
	}
	
	@Override
	public boolean deleteCustomerDao(int custId) {
		genObj.deleteObject(CustomerEntity.class,custId);
		return false;
	}

	@Override
	public List<CustomerEntity> getAllCustomerDao() {
		List<CustomerEntity>list=genObj.getAllObject(CustomerEntity.class);
		return list;
	}

	@Override
	public boolean updateCustomerDao(int custId) {
		genObj.updateObject(CustomerEntity.class,custId);
		return false;
	}


	

}
