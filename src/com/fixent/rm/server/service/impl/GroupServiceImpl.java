package com.fixent.rm.server.service.impl;

import java.util.List;

import com.fixent.rm.server.dao.GroupDAO;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.info.GroupInfo;
import com.fixent.rm.server.service.GroupService;

public class GroupServiceImpl 
implements GroupService {

	public Boolean createGroup(Group group) {
		
		Boolean status = false;
		
		try {
			
			GroupDAO dao = new GroupDAO();
			group.setId(dao.getMaxId());
			status = dao.createGroup(group);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return status;
	}

	public Boolean modifyGroup(Group group) {

		Boolean status = false;
		
		try {
			
			GroupDAO dao = new GroupDAO();
			status = dao.modifyGroup(group);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		return status;
	}

	public Boolean deleteGroup(Group group) {


		Boolean status = false;
		
		try {
			
			GroupDAO dao = new GroupDAO();
			status = dao.deleteGroup(group);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return status;
	}

	public Group getGroup(GroupInfo groupInfo) {
		
		Group group = null;
		
		try {
			
			GroupDAO dao = new GroupDAO();
			group = dao.getGroup(groupInfo);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return group;
	}

	public List<Group> getGroups(GroupInfo groupInfo) {
		
		List<Group> groups = null;
		
		try {
			
			GroupDAO dao = new GroupDAO();
			groups = dao.getGroups(groupInfo);
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return groups;
	}
	
}
