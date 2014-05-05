package com.fixent.rm.server.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Rent {
	
	int id;
	
	String shopName;
	
	Date leaseStartDate;
	
	Date leaseEndDate;
	
	Integer leaseYear;
	
	String paymentMode;
	
	BigDecimal rentPerSqrt;
	
	BigDecimal dueAmount;
	
	Shop shop;
	
	Set<Contact> contacts;
	
	Set<PaymentSchedule> paymentSchedules;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Integer getLeaseYear() {
		return leaseYear;
	}

	public void setLeaseYear(Integer leaseYear) {
		this.leaseYear = leaseYear;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public BigDecimal getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(BigDecimal dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<PaymentSchedule> getPaymentSchedules() {
		return paymentSchedules;
	}

	public void setPaymentSchedules(Set<PaymentSchedule> paymentSchedules) {
		this.paymentSchedules = paymentSchedules;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public BigDecimal getRentPerSqrt() {
		return rentPerSqrt;
	}

	public void setRentPerSqrt(BigDecimal rentPerSqrt) {
		this.rentPerSqrt = rentPerSqrt;
	}

}
