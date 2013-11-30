package com.fixent.rm.client.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Address;
import com.fixent.rm.server.model.Group;

public class AddressListDataTable extends AbstractTableModel {

	public AddressListDataTable(List<Address> addresses) {
		super();
		this.addresses = addresses;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Address> addresses;
	String columnList[] = new String[] {"Street", "City", "State", "Pincode" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return addresses != null ? addresses.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Address entity = addresses.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getStreet();
		case 1:
			return entity.getCity();
		case 2:
			return entity.getState();
		case 3:
			return entity.getCountry();
		case 4:
			return entity.getPincode();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
