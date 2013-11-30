package com.fixent.rm.server.service.impl;

import java.util.List;

import com.fixent.rm.server.dao.MaintenanceDAO;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.service.MaintenanceService;

public class MaintenanceServiceImpl 
implements MaintenanceService {

	@Override
	public boolean createGroup(Group group) {
		
		boolean status = false;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			int id = dao.getMaxId();
			group.setId(id+1);
			status = dao.createGroup(group);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Group> getGroups() {
		
		List<Group> books = null;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			books = dao.getGroups();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean deleteGroup(Group group) {
		
		boolean status = false;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			status = dao.deleteGroup(group);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean createShop(Shop shop) {
		
		boolean status = false;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			int id = dao.getShopMaxId();
			shop.setId(id+1);
			status = dao.createShop(shop);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Shop> getShops() {
		
		List<Shop> shops = null;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			shops = dao.getShops();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public boolean deleteShop(Shop shop) {
		
		boolean status = false;
		try {
			
			MaintenanceDAO dao = new MaintenanceDAO();
			status = dao.deleteShop(shop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
