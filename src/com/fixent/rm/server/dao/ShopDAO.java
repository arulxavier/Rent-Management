package com.fixent.rm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;

import com.fixent.rm.server.common.BaseDAO;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.info.ShopInfo;

public class ShopDAO 
extends BaseDAO {
	
	@SuppressWarnings("deprecation")
	public int getMaxId() throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SHOP;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id+1;
	}

	public Boolean createShop(Shop shop) 
	throws Exception {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(shop);
		session.getTransaction().commit();
		return true;
	}

	public Boolean modifyShop(Shop shop) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(shop);
		session.getTransaction().commit();
		return true;
	}

	public Boolean deleteShop(Shop shop) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(shop);
		session.getTransaction().commit();
		return true;
	}

	public Shop getShop(ShopInfo shopInfo) {

		Shop shop;
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Shop.class);
		
		if (shopInfo != null) {
			
			if (shopInfo.getShopId() != 0) {
				criteria.add(Restrictions.eq("id", shopInfo.getShopId()));
			}
		}
		shop = (Shop) criteria.list().get(0);
		initializeShop(shop);
		session.close();
		return shop;
	}

	@SuppressWarnings("unchecked")
	public List<Shop> getShops(ShopInfo shopInfo) {
		
		List<Shop> shops;
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Shop.class);
		shops = criteria.list();
		initializeShops(shops);
		return shops;
	}
	
private void initializeShops(List<Shop> shops) {
		
		for (Shop shop : shops) {
			
			initializeShop(shop);
		}
	}

	private void initializeShop(Shop shop) {
		
		if (shop instanceof HibernateProxy) {
			
			HibernateProxy hibernateProxy = (HibernateProxy) shop;
			Shop shop2 = (Shop) hibernateProxy;
			Hibernate.initialize(shop2);
		} else {
			Hibernate.initialize(shop);
		}
	}

}
