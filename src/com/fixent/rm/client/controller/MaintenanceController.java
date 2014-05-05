package com.fixent.rm.client.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import com.fixent.rm.client.common.BaseController;
import com.fixent.rm.client.view.GroupView;
import com.fixent.rm.client.view.MaintenanceView;
import com.fixent.rm.client.view.ShopView;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;
import com.fixent.rm.server.model.info.GroupInfo;
import com.fixent.rm.server.model.info.ShopInfo;
import com.fixent.rm.server.service.impl.GroupServiceImpl;
import com.fixent.rm.server.service.impl.ShopServiceImpl;

public class MaintenanceController 
extends BaseController {
	
	public MaintenanceView view;
	JDialog groupPopup;
	JDialog shopPopup;
	List<Group> groups;
	List<Shop> shops;
	
	
	public MaintenanceController() {
		
		prepopulate();
		initView();
		subscribeAction();
		setModel();
	}
	
	private void prepopulate() {
		
		
	}

	private void setModel() {
		
		setGroupModel();
		setShopModel();
		
	}

	private void setGroupModel() {
		
		GroupInfo groupInfo = new GroupInfo();
		GroupServiceImpl impl = new GroupServiceImpl();
		groups = impl.getGroups(groupInfo);		
		GroupDataTable dataModel = new GroupDataTable(groups);
		view.getGroupTable().setModel(dataModel);
		
	}

	private void setShopModel() {
		
		ShopInfo shopInfo = new ShopInfo();
		ShopServiceImpl impl = new ShopServiceImpl();
		shops = impl.getShops(shopInfo);		
		ShopDataTable dataModel = new ShopDataTable(shops);
		view.getShopTable().setModel(dataModel);
		
	}

	private void initView() {
		view = new MaintenanceView();
	}

	private void subscribeAction() {
		
		view.getGroupAddButton().addActionListener(new GroupAddAction());
		view.getGroupDeleteButton().addActionListener(new GroupDeleteAction());
		view.getShopAddButton().addActionListener(new ShopAddAction());
		view.getShopDeleteButton().addActionListener(new ShopDeleteAction());
	}

	class GroupAddAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			GroupView groupView = new GroupView();
			groupView.getSaveButton().addActionListener(new GroupSaveAction(groupView));
			groupView.getCancelButton().addActionListener(new GroupCancelAction());
			groupPopup = new JDialog();
			groupPopup.add(groupView);
			groupPopup.setSize(425, 300);
			groupPopup.setResizable(false);
			groupPopup.setLocationRelativeTo(null);
			groupPopup.setVisible(true);
		}
		
		
	}
	
	class GroupDeleteAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			final int row = view.getGroupTable().getSelectedRow();
			Group group = groups.get(row);
			GroupServiceImpl  impl = new GroupServiceImpl();
			impl.deleteGroup(group);
			setGroupModel();
		}
		
	}
	
	class GroupSaveAction
	implements ActionListener {
		
		GroupView groupView;
		
		public GroupSaveAction(GroupView groupView) {
			this.groupView = groupView; 
		}

		
		public void actionPerformed(ActionEvent e) {
			
			String groupName = groupView.getGroupNameTextField().getText();
			
			if (groupName != null && groupName.length() > 0) {
				
				GroupServiceImpl impl = new GroupServiceImpl();
				Group group = new Group();
				group.setName(groupName);
				impl.createGroup(group);
				setGroupModel();
				groupPopup.dispose();
			} else {
				groupView.getGroupNameTextField().setBackground(new Color(253, 215, 228));
				
			}
			
		}
		
		
	}
	
	class GroupCancelAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			groupPopup.dispose();
		}
		
	}
	
	class ShopAddAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			ShopView shopView = new ShopView();
			setComboBoxModel(shopView);
			shopView.getSaveButton().addActionListener(new ShopSaveAction(shopView));
			shopView.getCancelButton().addActionListener(new ShopCancelAction());
			shopPopup = new JDialog();
			shopPopup.add(shopView);
			shopPopup.setSize(480, 360);
			shopPopup.setResizable(false);
			shopPopup.setLocationRelativeTo(null);
			shopPopup.setVisible(true);			
		}

		private void setComboBoxModel(ShopView shopView) {
			
			DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
			boxModel.addElement("Select One");
			
			for (Group group : groups) {
				boxModel.addElement(group.getName());
			}
			shopView.getGroupNameComboBox().setModel(boxModel);
			
			
		}
		
		
	}
	
	class ShopDeleteAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			
			final int row = view.getShopTable().getSelectedRow();
			Shop shop = shops.get(row);
			ShopServiceImpl  impl = new ShopServiceImpl();
			impl.deleteShop(shop);
			setShopModel();
		}
		
	}
	
	class ShopSaveAction
	implements ActionListener {
		
		ShopView shopView;
		
		public ShopSaveAction(ShopView shopView) {
			this.shopView = shopView; 
		}

		
		public void actionPerformed(ActionEvent e) {
			
			String number = shopView.getShopNumberTextField().getText();
			BigDecimal sqrt = new BigDecimal(shopView.getSqrtTextField().getText());
			String groupName = shopView.getGroupNameComboBox().getSelectedItem().toString();
			
			if (number != null && number.length() > 0) {
				
				ShopServiceImpl impl = new ShopServiceImpl();
				Shop shop = new Shop();
				shop.setNumber(number);
				shop.setSquareFeet(sqrt);
				shop.setGroup(getGroup(groupName));
				impl.createShop(shop);
				setShopModel();
				shopPopup.dispose();
			} else {
				shopView.getShopNumberTextField().setBackground(new Color(253, 215, 228));
				
			}
			
		}
		
		
	}
	
	class ShopCancelAction
	implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			shopPopup.dispose();
		}
		
	}
	
	Group getGroup(String name) {
		
		for (Group group : groups) {
			
			if(name.equals(group.getName())) {
				return group;
			}
		}
		return null;
		
	}

}
