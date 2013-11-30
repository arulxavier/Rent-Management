package com.fixent.rm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fixent.rm.server.common.BaseDAO;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;

public class MaintenanceDAO 
extends BaseDAO {
	
	@SuppressWarnings("deprecation")
	public int getMaxId() 
			throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from GROUP_ST;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id;
	}

	public boolean createGroup(Group group) {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(group);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public List<Group> getGroups() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Group.class);
		List<Group> groups = criteria.list();
		session.close();
		return groups;
	}

	public boolean deleteGroup(Group group) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(group);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public int getShopMaxId() throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SHOP;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id;
	}

	public boolean createShop(Shop shop) {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(shop);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public List<Shop> getShops() {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Shop.class);
		List<Shop> shops = criteria.list();
		session.close();
		return shops;
	}
	
	public boolean deleteShop(Shop shop) {
		
		Session session = getSession();
		session.beginTransaction();
		session.delete(shop);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public Shop getShop(Shop shop) {
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Shop.class);
		criteria.add(Restrictions.eq("id", shop.getId()));
		return (Shop)criteria.list().get(0);
		
	}

}
