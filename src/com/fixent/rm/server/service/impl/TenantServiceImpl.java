package com.fixent.rm.server.service.impl;

import java.util.List;

import com.fixent.rm.server.dao.TenantDAO;
import com.fixent.rm.server.model.Tenant;
import com.fixent.rm.server.service.TenantService;

public class TenantServiceImpl 
implements TenantService {

	public boolean createTenant(Tenant tenant) {

		boolean status = false;
		try {

			TenantDAO dao = new TenantDAO();			
			int id = dao.getMaxId();
			tenant.setId(id+1);
			status = dao.createGroup(tenant);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Tenant> getTenants() {
		
		List<Tenant> tenants;
		
		try {
			
			TenantDAO dao = new TenantDAO();
			tenants = dao.getTenants();
			return tenants;
		} catch (Exception e) {
		}
		return null;
	}
}
