package com.scp.dao.service.impl;

import com.scp.dao.services.AdminUserDaoService;
import com.scp.generic.GenericClass;
import com.scp.mapping.pojo_entity.Mapping;
import com.scp.pojos.AdminPojo;

public class AdminUserDaoImpl implements AdminUserDaoService{

		GenericClass genObj=new GenericClass();
	@Override
	public boolean addAdminUserDao(AdminPojo user) {
		System.out.println("admin;;;;;;;;;;;;");
		genObj.saveObject(Mapping.mapPojoToEntity(user));
		return true;
	}

}
