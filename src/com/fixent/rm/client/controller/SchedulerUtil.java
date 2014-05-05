package com.fixent.rm.client.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fixent.rm.server.model.PaymentSchedule;

public class SchedulerUtil {
	
	public static List<PaymentSchedule> getSchedule(Date startDate, int year, Double dueAmount) {
		
		Double totalDue = new Double(0);
		
		DateFormat format = new SimpleDateFormat("dd-MMM-yyyy"); 
		Calendar yearStartDate = Calendar.getInstance();		
//		yearStartDate.set(2013, 9, 1);
		yearStartDate.setTime(startDate);
		
		System.out.println("Year Start Date : " + yearStartDate.getTime());
		Calendar yearEndDate = Calendar.getInstance();
		yearEndDate.setTime(yearStartDate.getTime());
//		yearEndDate.set(2014, 9, 31);
		yearEndDate.add(Calendar.YEAR, year);
		System.out.println("Year End Date : " + yearEndDate.getTime());
		
		Calendar monthStartDate = Calendar.getInstance();
		monthStartDate.setTime(yearStartDate.getTime());
		
		Calendar monthEndDate = Calendar.getInstance();
		
		List<PaymentSchedule> paymentSchedules  = new ArrayList<PaymentSchedule>();
		int i = 1;
		
		do {
			
			PaymentSchedule paymentSchedule = new PaymentSchedule();
//			paymentSchedule.setId(i);
			i++;
			paymentSchedule.setFromDate(monthStartDate.getTime());
			
//			int endDayOfCurrentMonth = monthStartDate.getMaximum(Calendar.DAY_OF_MONTH);
//			monthEndDate.set(monthStartDate.get(Calendar.YEAR), monthStartDate.get(Calendar.MONTH), endDayOfCurrentMonth);
			monthEndDate.setTime(monthStartDate.getTime());
			monthEndDate.add(Calendar.MONTH, 1);  
			monthEndDate.set(Calendar.DAY_OF_MONTH, 1);  
			monthEndDate.add(Calendar.DATE, -1);  
			
			paymentSchedule.setToDate(monthEndDate.getTime());
			paymentSchedule.setDueDate(monthEndDate.getTime());
			paymentSchedule.setDueAmount(dueAmount);
			totalDue = totalDue + dueAmount;
			paymentSchedule.setTotalDue(totalDue);
			paymentSchedule.setBookingDate(startDate);
			paymentSchedule.setExpirydate(yearEndDate.getTime());
			
			
			paymentSchedule.setServiceTax(new Double(12));
			paymentSchedule.setTaxAmount(new Double(12));
			paymentSchedule.setPaymentAmount(new Double(1200));
			paymentSchedule.setPaymentDate(new Date());
			
			
			paymentSchedules.add(paymentSchedule);
			monthStartDate.add(Calendar.MONTH, 1);
		} while (0 <= yearEndDate.compareTo(monthEndDate));
		
		for (PaymentSchedule paymentSchedule : paymentSchedules) {
			
			System.out.println("ID :" + paymentSchedule.getId() + " From Date :" + format.format(paymentSchedule.getFromDate()) 
					+ "  " + "To Date :" + format.format(paymentSchedule.getToDate()));
		}
		System.out.println("End");
		return paymentSchedules;
	}
	
	public static void main(String[] args) {
		
		Date date = new Date("01-Oct-2013");
		getSchedule(date, 1, new Double(1200));
	}

}
