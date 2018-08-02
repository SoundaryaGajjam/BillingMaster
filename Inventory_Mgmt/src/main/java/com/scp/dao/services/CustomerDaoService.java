package com.scp.dao.services;

import java.util.List;

import com.scp.entities.CustomerEntity;
import com.scp.pojos.CustomerPojo;

public interface CustomerDaoService {
	public boolean addCustomerDao(CustomerEntity cust);

	public boolean deleteCustomerDao(int custId);

	public CustomerEntity getCustomer(int custId);

	public List<CustomerEntity> getAllCustomerDao();

	public boolean updateCustomerDao(int custId);
}
