package com.fixent.rm.server.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Tenant {
	
	int id;
	String shopName;
	Date bookingDate;
	int year;
	String paymentMode;
	Double rentAmount;
	
	Shop shop;
	Set<Address> addresses;
	
	Set<Scheduler> schedulers;

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

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Scheduler> getSchedulers() {
		return schedulers;
	}

	public void setSchedulers(Set<Scheduler> schedulers) {
		this.schedulers = schedulers;
	}

	
	

}
