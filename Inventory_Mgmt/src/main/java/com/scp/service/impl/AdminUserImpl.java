package com.scp.service.impl;

import com.scp.dao.service.impl.AdminUserDaoImpl;
import com.scp.dao.services.AdminUserDaoService;
import com.scp.pojos.AdminPojo;
import com.scp.services.AdminUserService;

public class AdminUserImpl implements AdminUserService {
	AdminUserDaoService service=new AdminUserDaoImpl();
	@Override
	public boolean addUser(AdminPojo user) {
		service.addAdminUserDao(user);
		return true;
	}

}
