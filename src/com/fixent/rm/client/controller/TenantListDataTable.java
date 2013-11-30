package com.fixent.rm.client.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Tenant;

public class TenantListDataTable extends AbstractTableModel {

	public TenantListDataTable(List<Tenant> tenants) {
		super();
		this.tenants = tenants;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Tenant> tenants;
	String columnList[] = new String[] { "ID", "Shop Name" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return tenants != null ? tenants.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Tenant entity = tenants.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getShopName();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
