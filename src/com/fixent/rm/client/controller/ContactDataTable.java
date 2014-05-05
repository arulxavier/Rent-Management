package com.fixent.rm.client.controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Contact;

public class ContactDataTable extends AbstractTableModel {

	public ContactDataTable(List<Contact> contacts) {
		super();
		this.contacts = contacts;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Contact> contacts;
	String columnList[] = new String[] {"Name", "Mobile Number", "Street", "City", "State", "Pincode" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return contacts != null ? contacts.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		Contact entity = contacts.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getName();
		case 1:
			return entity.getMobileNumber();
		case 2:
			return entity.getAddress().getStreet1();
		case 3:
			return entity.getAddress().getCity();
		case 4:
			return entity.getAddress().getState();
		case 5:
			return entity.getAddress().getCountry();
		case 6:
			return entity.getAddress().getPincode();
		default:
			return null;
		}
	}

	
	public String getColumnName(int col) {
		return columnList[col];
	}

}
