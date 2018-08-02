package com.scp.dao.services;

import java.util.List;

import com.scp.entities.ProductEntity;
import com.scp.pojos.CustomerPojo;
import com.scp.pojos.ProductPojo;

public interface ProductDaoService {
	public boolean addProductDao(ProductEntity prod);
	public boolean deleteProductDao(int prodId);

	public ProductEntity getProductDao(int prodId);

	public List<ProductEntity> getAllProductDao();
	public boolean updateProductDao(int prodId);
}
