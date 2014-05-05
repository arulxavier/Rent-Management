package com.fixent.rm.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;

import com.fixent.rm.server.common.BaseDAO;
import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.info.GroupInfo;

public class GroupDAO 
extends BaseDAO {
	

	@SuppressWarnings("deprecation")
	public int getMaxId() 
	throws Exception {

		int id = 0;

		Session session = getSession();
		Connection connection = session.connection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select max(id) from SHOP_GROUP;");
		ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) {
			id = resultSet.getInt(1);
		}

		return id+1;
	}

	public Boolean createGroup(Group group) 
	throws Exception {
		
		Session session = getSession();
		session.beginTransaction();
		session.save(group);
		session.getTransaction().commit();
		return true;
	}

	public Boolean modifyGroup(Group group) {

		Session session = getSession();
		session.beginTransaction();
		session.merge(group);
		session.getTransaction().commit();
		return true;
	}

	public Boolean deleteGroup(Group group) {

		Session session = getSession();
		session.beginTransaction();
		session.delete(group);
		session.getTransaction().commit();
		return true;
	}

	public Group getGroup(GroupInfo GroupInfo) {

		Group group;
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Group.class);
		group = (Group) criteria.list().get(0);
		initializeGroup(group);
		return group;
	}

	public List<Group> getGroups(GroupInfo GroupInfo) {
		
		List<Group> groups;
		
		Session session = getSession();
		Criteria criteria = session.createCriteria(Group.class);
		groups = criteria.list();
		initializeGroups(groups);
		return groups;
	}
	
	private void initializeGroups(List<Group> groups) {
		
		for (Group group : groups) {
			
			initializeGroup(group);
		}
	}

	private void initializeGroup(Group group) {
		
		if (group instanceof HibernateProxy) {
			
			HibernateProxy hibernateProxy = (HibernateProxy) group;
			Group group2 = (Group) hibernateProxy;
			Hibernate.initialize(group2);
		} else {
			Hibernate.initialize(group);
		}
	}

}
