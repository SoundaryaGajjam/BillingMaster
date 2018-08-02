package com.scp.services;

import java.util.List;

import com.scp.pojos.CustomerPojo;

public interface CustomerService {
	public boolean addCustomer(CustomerPojo cust);
	
	public CustomerPojo getCustomer(int custId);
	
	public List<CustomerPojo> getAllCustomer();
	
	public boolean deleteCustomer(int custId);
	
	public boolean updateCustomer(int custId);
	
}
