package com.fixent.rm.server.service;

import java.util.List;

import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;

public interface MaintenanceService {
	
	boolean createGroup(Group group);
	
	List<Group> getGroups();
	
	boolean deleteGroup(Group group);
	
	boolean createShop(Shop shop);
	
	List<Shop> getShops();
	
	boolean deleteShop(Shop shop);
	

}
