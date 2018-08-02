package com.scp.service.impl;

import java.util.List;

import com.scp.dao.service.impl.ProductDaoImpl;
import com.scp.dao.services.ProductDaoService;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.ProductPojo;
import com.scp.services.ProductService;

public class ProductImpl implements ProductService{
	
	ProductDaoService service=new ProductDaoImpl();
	@Override
	public boolean addProduct(ProductPojo prod) {
		service.addProductDao(Mapping.mapPojoToEntity(prod));
		return true;
	}
	@Override
	public ProductPojo getProduct(int prodId) {
		ProductPojo prodPojo=Mapping.mapEntityToPojo(service.getProductDao(prodId));
		return prodPojo;
	}
	@Override
	public List<ProductPojo> getAllProduct() {
		List<ProductPojo>listOfProd=Mapping.mapListOfEntitiestoListOfPojos(service.getAllProductDao());
		return listOfProd;
	}
	@Override
	public boolean deleteProduct(int prodId) {
		service.deleteProductDao(prodId);
		return true;
	}
	@Override
	public boolean updateProduct(int prodId) {
		service.updateProductDao(prodId);
		return false;
	}

}
