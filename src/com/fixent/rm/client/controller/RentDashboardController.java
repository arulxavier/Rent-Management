package com.fixent.rm.client.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fixent.rm.client.common.BaseController;
import com.fixent.rm.client.common.RightPanel;
import com.fixent.rm.client.view.RentDashboardView;

public class RentDashboardController 
extends BaseController {

	public RentDashboardView view;
	
	public RentDashboardController() {
		
		initialize();
	}

	private void initialize() {
		
		view = new RentDashboardView();
		view.getSearchButton().addActionListener(new SearchAction());
		view.getAddButton().addActionListener(new AddAction());
		
	}
	
	class SearchAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String shopNumber = view.getShopNumberTextField().getText();
			
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new RentListController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
		}
		
	}
	
	class AddAction
	implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			push("SCREEN_MODE", "Add");
			RightPanel rightSidePanel = (RightPanel)view.getParent();
			rightSidePanel.removeAll();
			rightSidePanel.add(new RentController().view, BorderLayout.CENTER);
			rightSidePanel.repaint();
			rightSidePanel.revalidate();
			rightSidePanel.setVisible(true);
			
		}
		
	}
	
}
