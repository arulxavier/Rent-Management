package com.fixent.rm.server.service;

import java.util.List;

import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.info.ShopInfo;

public interface ShopService {
	
	public Boolean createShop(Shop shop);
	
	public Boolean modifyShop(Shop shop);
	
	public Boolean deleteShop(Shop shop);
	
	public Shop getShop(ShopInfo shopInfo);
	
	public List<Shop> getShops(ShopInfo shopInfo);

}
