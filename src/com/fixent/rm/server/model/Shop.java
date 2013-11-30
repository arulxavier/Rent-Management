package com.fixent.rm.server.model;

public class Shop {
	
	int id;
	String shopName;
	Double sqrt;
	Group group;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Double getSqrt() {
		return sqrt;
	}
	public void setSqrt(Double sqrt) {
		this.sqrt = sqrt;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
}
