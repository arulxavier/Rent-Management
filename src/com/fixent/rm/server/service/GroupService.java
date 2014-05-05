package com.fixent.rm.server.service;

import java.util.List;

import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.info.GroupInfo;

public interface GroupService {
	
	public Boolean createGroup(Group group);
	
	public Boolean modifyGroup(Group group);
	
	public Boolean deleteGroup(Group group);
	
	public Group getGroup(GroupInfo groupInfo);
	
	public List<Group> getGroups(GroupInfo groupInfo);

}
