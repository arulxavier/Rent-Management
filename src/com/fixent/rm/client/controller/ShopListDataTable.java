package com.fixent.rm.client.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Shop;

public class ShopListDataTable extends AbstractTableModel {

	public ShopListDataTable(List<Shop> shops) {
		super();
		this.shops = shops;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Shop> shops;
	String columnList[] = new String[] { "ID", "Shop Name" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return shops != null ? shops.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Shop entity = shops.get(rowIndex);
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
