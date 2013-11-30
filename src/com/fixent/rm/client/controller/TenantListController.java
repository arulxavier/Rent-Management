package com.fixent.rm.client.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.fixent.rm.client.common.BaseController;
import com.fixent.rm.client.common.ClientConstant;
import com.fixent.rm.client.common.RightPanel;
import com.fixent.rm.client.view.TenantListView;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Tenant;
import com.fixent.rm.server.service.impl.MaintenanceServiceImpl;
import com.fixent.rm.server.service.impl.TenantServiceImpl;

public class TenantListController 
extends BaseController {
	
	public TenantListView view;
	List<Tenant> tenants;
	
	public TenantListController() {
		
		initView();
		prepopulate();
		subscribeAction();
	}

	private void prepopulate() {
		
		TenantServiceImpl impl = new TenantServiceImpl();
		tenants = impl.getTenants();
		TenantListDataTable dataModel = new TenantListDataTable(tenants);
		view.getTenantListTable().setModel(dataModel);
		
		
		
	}

	private void subscribeAction() {
		
		view.getAddButton().addActionListener(new AddAction());
		view.getModifyButton().addActionListener(new ModifyAction());
		view.getDeleteButton().addActionListener(new DeleteAction());
	}

	private void initView() {
		
		view = new TenantListView();
	}
	
	class AddAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			push(ClientConstant.DISPLAY_MODE, ClientConstant.ADD);
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new TenantController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);			
		}
		
	}
	
	class ModifyAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			final int row = view.getTenantListTable().getSelectedRow();
			Tenant tenant = tenants.get(row);
			
			push(ClientConstant.DATA, tenant);
			push(ClientConstant.DISPLAY_MODE, ClientConstant.MODIFY);
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new TenantController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);	
			
		}
		
	}
	
	class DeleteAction
	implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	 

}
