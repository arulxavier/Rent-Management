package com.fixent.rm.client.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Group;

public class GroupListDataTable extends AbstractTableModel {

	public GroupListDataTable(List<Group> groups) {
		super();
		this.groups = groups;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Group> groups;
	String columnList[] = new String[] { "ID", "Group Name" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return groups != null ? groups.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Group entity = groups.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getGroupName();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
