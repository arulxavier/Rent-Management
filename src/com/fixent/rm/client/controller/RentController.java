package com.fixent.rm.client.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.fixent.rm.client.common.BaseController;
import com.fixent.rm.client.common.RightPanel;
import com.fixent.rm.client.view.ContactView;
import com.fixent.rm.client.view.RentView;
import com.fixent.rm.server.model.Address;
import com.fixent.rm.server.model.Contact;
import com.fixent.rm.server.model.PaymentSchedule;
import com.fixent.rm.server.model.Rent;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.info.ShopInfo;
import com.fixent.rm.server.service.impl.ShopServiceImpl;

public class RentController 
extends BaseController {
	
	RentView view;
	Rent rent;
	List<Contact> contacts;
	List<PaymentSchedule> paymentSchedules;
	List<Shop> shops;
	JDialog contactPopup;
	String screenMode;
	Shop shop;
	
	public RentController() {
		
		initialize();
		prePopulate();
		setView();
		setScreenMode();
	}

	private void initialize() {
		
		screenMode = (String) pop("SCREEN_MODE");
		view = new RentView();
		view.getSaveButton().addActionListener(new SaveAction());
		view.getCancelButton().addActionListener(new CancelAction());
		view.getGenerateButton().addActionListener(new GenerateAction());
		view.getAddButton().addActionListener(new AddAction());
		view.getDeleteButton().addActionListener(new DeleteAction());
		view.getLeaseStartDatePicker().getDateField().addCaretListener(new LeaseStartDateAction());
		view.getPaymentOptionComboBox().addItemListener(new PaymentOptionAction());
		view.getNoOfYearComboBox().addItemListener(new NoOfYearAction());
		view.getShopNumberComboBox1().addItemListener(new ShopNumberAction());
		view.getRentPerSqrtTextField().addFocusListener(new RentPerSqrtAction());
		
	}

	private void prePopulate() {
		
		if (shops == null) {
			
			ShopServiceImpl impl = new ShopServiceImpl();
			ShopInfo info = new ShopInfo();
			shops = impl.getShops(info);
		}
		
		DefaultComboBoxModel shopNumberModel = new DefaultComboBoxModel();
		shopNumberModel.addElement("Select One");

		for (Shop shop : shops) {

			shopNumberModel.addElement(shop.getNumber());
		}
		view.getShopNumberComboBox1().setModel(shopNumberModel);
		
		DefaultComboBoxModel noOfYearModel = new DefaultComboBoxModel();
		noOfYearModel.addElement("Select One");
		
		for (int i=1; i <=10; i++) {
			noOfYearModel.addElement(i);
		}
		view.getNoOfYearComboBox().setModel(noOfYearModel);
		
		DefaultComboBoxModel paymentOptionModel = new DefaultComboBoxModel();
		paymentOptionModel.addElement("Select One");
		paymentOptionModel.addElement("Rent Per Square Feet");
		paymentOptionModel.addElement("Fixed");
		view.getPaymentOptionComboBox().setModel(paymentOptionModel);
		
		setPaymentSchedule();
		setContact();
		
	}
	
	private void setView() {
		
		if (rent != null) {
			
			view.getShopNumberComboBox1().setSelectedItem(rent.getShop().getNumber());
			view.getShopNameTextField().setText(rent.getShopName());
			view.getLeaseStartDatePicker().setDateTextField(rent.getLeaseStartDate());
			view.getLeaseEndDatePicker().setDateTextField(rent.getLeaseEndDate());
			view.getNoOfYearComboBox().setSelectedItem(rent.getLeaseYear());
			view.getRentPerSqrtTextField().setText(rent.getRentPerSqrt().toString());
			view.getDueAmountTextField().setText(rent.getDueAmount().toString());
			
			paymentSchedules = new ArrayList<PaymentSchedule>();
			paymentSchedules.addAll(rent.getPaymentSchedules());
			setPaymentSchedule();
			
			contacts = new ArrayList<Contact>();
			contacts.addAll(rent.getContacts());
			setContact();
		}
		
	}
	
	private void setScreenMode() {
		
		if (screenMode.equals("Add")) {
			
			view.getNoOfYearComboBox().setEnabled(false);
			view.getLeaseEndDatePicker().setEditable(false);
			view.getRentPerSqrtTextField().setEditable(false);
			view.getDueAmountTextField().setEditable(false);
		}
		
	}
	
	private void setPaymentSchedule() {

		SchedulerListDataTable dataModel = new SchedulerListDataTable(paymentSchedules);
		view.getPaymentScheduleTable().setModel(dataModel);
	}

	class SaveAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			getModel();
		}
	}
	
	class CancelAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new RentDashboardController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
	}
	
	class GenerateAction
	implements ActionListener {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			
			Date bookingDate = new Date(view.getLeaseStartDatePicker().getjTextField1());
			int year  = Integer.parseInt(view.getNoOfYearComboBox().getSelectedItem().toString());
			Double dueAmount = Double.valueOf(view.getDueAmountTextField().getText());
			paymentSchedules = SchedulerUtil.getSchedule(bookingDate, year, dueAmount);
			
			setPaymentSchedule();
			
		}
	}
	
	private void getModel() {
		
		if (rent == null) {
			rent = new Rent();
		}
		
		rent.setShop(getShop(view.getShopNumberComboBox1().getSelectedItem().toString()));
		
	}


	private Shop getShop(String shopNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class AddAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			ContactView contactView = new ContactView();
			contactView.getCityTextField().setText("Trichy");
			contactView.getStateTextField().setText("Tamil Nadu");
			contactView.getCountryTextField().setText("India");
			
			contacts = new ArrayList<Contact>();
			
			contactView.getSaveButton().addActionListener(new ContactSaveAction(contactView));
			contactView.getCancelButton().addActionListener(new ContactCancelAction());
			
			contactPopup = new JDialog();
			contactPopup.add(contactView);
			contactPopup.setSize(670, 360);
			contactPopup.setResizable(false);
			contactPopup.setLocationRelativeTo(null);
			contactPopup.setVisible(true);
		}
		
	}
	
	class DeleteAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	class ContactSaveAction
	implements ActionListener {
		
		ContactView contactView;
		
		public ContactSaveAction(ContactView contactView) {
			this.contactView = contactView;
		}

		public void actionPerformed(ActionEvent e) {
			
			Contact contact = new Contact();
			Address address = new Address();
			
			String name = contactView.getNameTextField().getText();
			String mobileNumber = contactView.getMobileNumberTextField().getText();
			String street1 = contactView.getStreet1TextField().getText();
			String street2 = contactView.getStreet2TextField().getText();
			String city = contactView.getCityTextField().getText();
			String state = contactView.getStateTextField().getText();
			String country = contactView.getCountryTextField().getText();
			int pincode = Integer.parseInt(contactView.getPincodeTextField().getText());
			
			address.setStreet1(street1);
			address.setStreet2(street2);
			address.setCity(city);
			address.setState(state);
			address.setCountry(country);
			address.setPincode(pincode);
			
			contact.setAddress(address);
			contact.setName(name);
			contact.setMobileNumber(mobileNumber);
			
			contacts.add(contact);
			
			setContact();
			contactPopup.dispose();
			
		}
	}
	
	private void setContact() {
		
		ContactDataTable dataModel = new ContactDataTable(contacts);
		view.getContactTable().setModel(dataModel);
	}
	
	class ContactCancelAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			contactPopup.dispose();			
		}
		
		
	}
	
	class LeaseStartDateAction
	implements CaretListener {

		public void caretUpdate(CaretEvent e) {
			
			view.getNoOfYearComboBox().setEnabled(true);
		}
		
		
	}
	
	class PaymentOptionAction
	implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			String paymentOption = view.getPaymentOptionComboBox().getSelectedItem().toString();
			
			if ("Rent Per Square Feet".equals(paymentOption)) {
				view.getRentPerSqrtTextField().setEditable(true);
				view.getDueAmountTextField().setEditable(false);
				view.getDueAmountTextField().setText("");
			} else {
				
				view.getRentPerSqrtTextField().setEditable(false);
				view.getDueAmountTextField().setEditable(true);
				view.getRentPerSqrtTextField().setText("");
			}
		}
	}
	
	class NoOfYearAction
	implements ItemListener {

		public void itemStateChanged(ItemEvent e) {

			if (view.getLeaseStartDatePicker().getjTextField1() != null
					&& !view.getLeaseStartDatePicker().getjTextField1().isEmpty()
					&& view.getNoOfYearComboBox().getSelectedItem() != null
					&& !view.getNoOfYearComboBox().getSelectedItem().toString().equals("Select One")) {
				
				int noOfYear = Integer.parseInt(view.getNoOfYearComboBox().getSelectedItem().toString());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date(view.getLeaseStartDatePicker().getjTextField1()));
				
//				calendar.add(Calendar.YEAR, noOfYear);
//				calendar.add(Calendar.MONTH, -1);
//				calendar.set(Calendar.DATE,	calendar.get(Calendar.DATE));
				calendar.add(Calendar.YEAR, noOfYear);
				view.getLeaseEndDatePicker().setDateTextField(calendar.getTime());
			}
		}
	}
	
	class RentPerSqrtAction
	implements FocusListener {

		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void focusLost(FocusEvent e) {
			
			BigDecimal sqrtFeet = shop.getSquareFeet();
			BigDecimal rentPerSqrt = new BigDecimal(view.getRentPerSqrtTextField().getText());
			BigDecimal dueAmount = sqrtFeet.multiply(rentPerSqrt);
			view.getDueAmountTextField().setText(dueAmount.toString());
			
		}
		
	}
	
	class ShopNumberAction
	implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			
			shop = getShop();
		}
		
	}
	
	private Shop getShop() {
		
		Shop shop = null;
		String shopName = view.getShopNumberComboBox1().getSelectedItem().toString();
		
		if (shops != null) {
			
			for (Shop shop2 : shops) {
				
				if (shopName.equals(shop2.getNumber())) {
					
					shop = shop2;
					break;
				}
			}
		}
		return shop;
	}
}
