package com.fixent.rm.client.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.PaymentSchedule;

public class SchedulerListDataTable 
extends AbstractTableModel {
	
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

	public SchedulerListDataTable(List<PaymentSchedule> schedulers) {
		super();
		this.schedulers = schedulers;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<PaymentSchedule> schedulers;
	String columnList[] = new String[] {"From Date", "Due Date", "Due Amount", "Total Due" };

	
	public int getColumnCount() {
		return columnList.length;
	}

	
	public int getRowCount() {
		return schedulers != null ? schedulers.size() : 0;
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {

		PaymentSchedule entity = schedulers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return DATE_FORMAT.format(entity.getFromDate());
		case 1:
			return DATE_FORMAT.format(entity.getDueDate());
		case 2:
			return entity.getDueAmount();
		case 3:
			return entity.getTotalDue();
		default:
			return null;
		}
	}

	
	public String getColumnName(int col) {
		return columnList[col];
	}

}
