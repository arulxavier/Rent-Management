package com.fixent.rm.client.controller;

import com.fixent.rm.client.view.RentListView;

public class RentListController {
	
	RentListView view;
	
	public RentListController() {
		
		initialize();
	}

	private void initialize() {
		
		view = new RentListView();
	}

}
