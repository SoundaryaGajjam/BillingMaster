package com.scp.services;

import java.util.List;

import com.scp.pojos.CustomerPojo;
import com.scp.pojos.ProductPojo;

public interface ProductService {
	public boolean addProduct(ProductPojo prod);
	
	public ProductPojo getProduct(int prodId);
	
	public List<ProductPojo> getAllProduct();
	
	public boolean deleteProduct(int prodId);
	
	public boolean updateProduct(int prodId );
}
