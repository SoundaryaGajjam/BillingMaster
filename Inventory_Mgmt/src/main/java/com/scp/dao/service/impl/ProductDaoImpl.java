package com.scp.dao.service.impl;

import java.util.List;

import com.scp.dao.services.ProductDaoService;
import com.scp.entities.ProductEntity;
import com.scp.generic.GenericClass;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.ProductPojo;

public class ProductDaoImpl implements ProductDaoService{
	GenericClass genObj=new GenericClass();
	@Override
	public boolean addProductDao(ProductEntity prod) {
		System.out.println("prod dao");
		genObj.saveObject(prod);
		return true;
	}
	@Override
	public ProductEntity getProductDao(int prodId) {
		ProductEntity prod=(ProductEntity) genObj.getObject(ProductEntity.class,prodId);
		return prod;
	}
	@Override
	public boolean deleteProductDao(int prodId) {
		genObj.deleteObject(ProductEntity.class,prodId);
		return true;
	}
	
	@Override
	public List<ProductEntity> getAllProductDao() {
		List<ProductEntity>listOfProd=genObj.getAllObject(ProductEntity.class);
		return listOfProd;
	}
	@Override
	public boolean updateProductDao(int prodId) {
		genObj.updateObject(ProductEntity.class, prodId);
		return false;
	}

}
