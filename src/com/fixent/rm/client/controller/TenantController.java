package com.fixent.rm.client.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import com.fixent.rm.client.common.BaseController;
import com.fixent.rm.client.common.ClientConstant;
import com.fixent.rm.client.common.RightPanel;
import com.fixent.rm.client.view.AddressView;
import com.fixent.rm.client.view.TenantView;
import com.fixent.rm.server.model.Address;
import com.fixent.rm.server.model.Scheduler;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.Tenant;
import com.fixent.rm.server.service.impl.MaintenanceServiceImpl;
import com.fixent.rm.server.service.impl.TenantServiceImpl;

public class TenantController 
extends BaseController {
	
	public TenantView view;
	List<Shop> shops;
	JDialog addressPopup;
	List<Address> addresses;
	List<Scheduler> schedulers;
	Tenant tenant;
	String viewMode;
	
	public TenantController() {
		
		initView();
		prepopulate();
		subscribeAction();
		setModel();
	}
	
	private void prepopulate() {
		
		MaintenanceServiceImpl impl = new MaintenanceServiceImpl();
		shops = impl.getShops();
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement("Select One");
		for (Shop shop : shops) {
			boxModel.addElement(shop.getShopName());
		}
		view.getShopNumberComboBox().setModel(boxModel);
		
	}

	private void initView() {
		
		viewMode = pop(ClientConstant.DISPLAY_MODE).toString();
		
		view = new TenantView();
		if (ClientConstant.ADD.equals(viewMode)) {
			
			addresses = new ArrayList<Address>();
			
		} else if (ClientConstant.MODIFY.equals(viewMode)) {
			
			tenant = (Tenant) pop(ClientConstant.DATA);
		}
	}
	
	private void setModel() {
		
		view.getShopNumberComboBox().setSelectedItem(tenant.getShop().getShopName());
		view.getShopNameTextField().setText(tenant.getShopName());
		view.getBookingDatePicker().setDateTextField(DATE_FORMAT.format(tenant.getBookingDate()));
		view.getYearComboBox().setSelectedItem(tenant.getYear());
		view.getPaymentModeComboBox().setSelectedItem(tenant.getPaymentMode());
		view.getRentAmountTextField().setText(tenant.getRentAmount().toString());
		setScheduleModel(tenant.getSchedulers());
		setAddressModel(tenant.getAddresses());
		
	}

	private void setAddressModel(Set<Address> addresses2) {
		
		addresses = new ArrayList<Address>();
		addresses.addAll(addresses2);
		AddressListDataTable dataModel = new AddressListDataTable(addresses);
		view.getjTable1().setModel(dataModel);
		
	}

	private void setScheduleModel(Set<Scheduler> schedulers2) {
		
		schedulers = new ArrayList<Scheduler>();
		schedulers.addAll(schedulers2);
		SchedulerListDataTable dataModel = new SchedulerListDataTable(schedulers);
		view.getSchedulerTable().setModel(dataModel);		
	}

	private void subscribeAction() {
		
		view.getGenerateButton().addActionListener(new GenerateScheduleAction());
		view.getAddButton().addActionListener(new AddAction());
		view.getDeleteButton().addActionListener(new DeleteAction());
		view.getSaveButton().addActionListener(new SaveAction());
	}
	
	class GenerateScheduleAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			@SuppressWarnings("deprecation")
			Date bookingDate = new Date(view.getBookingDatePicker().getjTextField1());
			int year  = Integer.parseInt(view.getYearComboBox().getSelectedItem().toString());
			Double dueAmount = Double.valueOf(view.getRentAmountTextField().getText());
			schedulers = SchedulerUtil.getSchedule(bookingDate, year, dueAmount);
			
			SchedulerListDataTable dataModel = new SchedulerListDataTable(schedulers);
			view.getSchedulerTable().setModel(dataModel);
			
		}
		
	}
	
	class AddAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			
			AddressView addressView = new AddressView();
			addressView.getSaveButton().addActionListener(new AddressSaveAction(addressView));
			addressView.getCancelButton().addActionListener(new AddressCancelAction());
			addressPopup = new JDialog();
			addressPopup.add(addressView);
			addressPopup.setSize(425, 300);
			addressPopup.setResizable(false);
			addressPopup.setLocationRelativeTo(null);
			addressPopup.setVisible(true);
		}
	}
	
	class DeleteAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	
	class AddressSaveAction
	implements ActionListener {
		
		AddressView addressView;
		
		public AddressSaveAction(AddressView addressView) {
			this.addressView = addressView;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Address address = new Address();
			address.setStreet(addressView.getStreetTextField().getText());
			address.setCity(addressView.getCityTextField().getText());
			address.setState(addressView.getStateTextField().getText());
			address.setCountry(addressView.getCountryTextField().getText());
			address.setPincode(addressView.getPincodeTextField().getText());
			addresses.add(address);
			
			AddressListDataTable dataModel = new AddressListDataTable(addresses);
			view.getjTable1().setModel(dataModel);
			addressPopup.dispose();
			
			
		}
		
	}
	
	class AddressCancelAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			addressPopup.dispose();
		}
		
	}
	
	class SaveAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if (ClientConstant.ADD.equals(viewMode)) {
				
				tenant = new Tenant();
				
			} else if (ClientConstant.MODIFY.equals(viewMode)) {
				
			}
			
			
			tenant.setShop(getShop(view.getShopNumberComboBox().getSelectedItem().toString()));
			tenant.setShopName(view.getShopNameTextField().getText());
			tenant.setBookingDate(new Date(view.getBookingDatePicker().getjTextField1()));
			tenant.setYear(Integer.parseInt(view.getYearComboBox().getSelectedItem().toString()));
			tenant.setPaymentMode(view.getPaymentModeComboBox().getSelectedItem().toString());
			tenant.setRentAmount(Double.valueOf(view.getRentAmountTextField().getText()));
			Set<Scheduler> schedulersSet = new HashSet<Scheduler>();
			Set<Address> addressesSet = new HashSet<Address>();
			addressesSet.addAll(addresses);
			schedulersSet.addAll(schedulers);
			tenant.setSchedulers(schedulersSet);
			tenant.setAddresses(addressesSet);
			
			TenantServiceImpl impl  = new TenantServiceImpl();
			impl.createTenant(tenant);
			
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new TenantListController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	Shop getShop(String shopNumber) {
		
		for(Shop shop : shops) {
			
			if (shop.getShopName().equals(shopNumber)) {
				return shop;
			}
			
		}
		return null;
	}
	
	
}
