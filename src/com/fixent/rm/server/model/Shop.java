package com.fixent.rm.server.model;

import java.math.BigDecimal;

public class Shop {
	
	int id;
	String number;
	BigDecimal squareFeet;
	Group group;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getSquareFeet() {
		return squareFeet;
	}
	public void setSquareFeet(BigDecimal squareFeet) {
		this.squareFeet = squareFeet;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
