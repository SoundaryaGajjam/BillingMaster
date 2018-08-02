package com.scp.service.impl;

import java.util.List;

import com.scp.dao.service.impl.CustomerDaoImpl;
import com.scp.dao.services.CustomerDaoService;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.CustomerPojo;
import com.scp.services.CustomerService;

public class CustomerImpl implements CustomerService{
	
	CustomerDaoService service=new CustomerDaoImpl();
	@Override
	public boolean addCustomer(CustomerPojo cust) {
		//System.out.println("cust impl");
		service.addCustomerDao(Mapping.mapPojoToEntity(cust));
		return false;
	}
	
	@Override
	public CustomerPojo getCustomer(int custId) {
		CustomerPojo custPojo=Mapping.mapEntityToPojo(service.getCustomer(custId));
		return custPojo;
	}
	@Override
	public boolean deleteCustomer(int custId) {
		service.deleteCustomerDao(custId);
		return true;
	}

	@Override
	public List<CustomerPojo> getAllCustomer() {
		List<CustomerPojo>listOfCust=Mapping.mapListOfEntitiestoListOfPojos(service.getAllCustomerDao());
		return listOfCust;
	}

	@Override
	public boolean updateCustomer(int custId) {
		service.updateCustomerDao(custId);
		return true;
	}
	

}
