package com.fixent.rm.server.service.impl;

import java.util.List;

import com.fixent.rm.server.dao.ShopDAO;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.info.ShopInfo;
import com.fixent.rm.server.service.ShopService;

public class ShopServiceImpl 
implements ShopService {

	public Boolean createShop(Shop shop) {
		
		Boolean status = false;
		
		try {
			
			ShopDAO dao = new ShopDAO();
			shop.setId(dao.getMaxId());
			status = dao.createShop(shop);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return status;
	}

	public Boolean modifyShop(Shop shop) {

		Boolean status = false;
		
		try {
			
			ShopDAO dao = new ShopDAO();
			status = dao.modifyShop(shop);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		return status;
	}

	public Boolean deleteShop(Shop shop) {


		Boolean status = false;
		
		try {
			
			ShopDAO dao = new ShopDAO();
			ShopInfo shopInfo = new ShopInfo();
			shopInfo.setShopId(shop.getId());			
			shop = dao.getShop(shopInfo);
			status = dao.deleteShop(shop);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return status;
	}

	public Shop getShop(ShopInfo shopInfo) {
		
		Shop shop = null;
		
		try {
			
			ShopDAO dao = new ShopDAO();
			shop = dao.getShop(shopInfo);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return shop;
	}

	public List<Shop> getShops(ShopInfo shopInfo) {
		
		List<Shop> shops = null;
		
		try {
			
			ShopDAO dao = new ShopDAO();
			shops = dao.getShops(shopInfo);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return shops;
	}

}
