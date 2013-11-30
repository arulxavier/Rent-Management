package com.fixent.rm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;

import com.fixent.rm.server.common.BaseDAO;
import com.fixent.rm.server.model.Address;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Scheduler;
import com.fixent.rm.server.model.Tenant;

public class TenantDAO 
extends BaseDAO{


	public int getMaxId() 
			throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from TENANT;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id;
	}

	public boolean createGroup(Tenant tenant) {

		Session session = getSession();
		session.beginTransaction();
		session.save(tenant);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public List<Tenant> getTenants() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Tenant.class);
		List<Tenant> tenants = criteria.list();
		initializeTenant(tenants);
		session.close();
		return tenants;
	}

	private void initializeTenant(List<Tenant> tenants) {
		
		for (Tenant tenant : tenants) {
			
			Hibernate.initialize(tenant);
			Hibernate.initialize(tenant.getShop());
			Hibernate.initialize(tenant.getAddresses());
			if (tenant.getAddresses() instanceof HibernateProxy) {
				HibernateProxy hibernateProxy = (HibernateProxy) tenant.getAddresses();
				Set<Address> addresses = (Set<Address>) hibernateProxy;
			}
			for (Address address : tenant.getAddresses()) {
				Hibernate.initialize(address);
			}	


			Hibernate.initialize(tenant.getSchedulers());
			if (tenant.getSchedulers() instanceof HibernateProxy) {
				HibernateProxy hibernateProxy = (HibernateProxy) tenant.getSchedulers();
				Set<Scheduler> addresses = (Set<Scheduler>) hibernateProxy;
			}
			for (Scheduler scheduler : tenant.getSchedulers()) {
				Hibernate.initialize(scheduler);
			}
		}
		
	}
}
