package com.fixent.rm.server.service.impl;

import com.fixent.rm.server.model.Group;

public class TestMaintenanceServiceImpl {
	
	public static void createGroup() {
		
		Group group = new Group();
		group.setGroupName("name33");
		
		MaintenanceServiceImpl impl = new MaintenanceServiceImpl();
		impl.createGroup(group);
	}
	
	public static void main(String[] args) {
		TestMaintenanceServiceImpl.createGroup();
	}

}
