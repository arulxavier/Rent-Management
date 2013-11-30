package com.fixent.rm.client.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.fixent.rm.server.model.Group;
import com.fixent.rm.server.model.Scheduler;

public class SchedulerListDataTable 
extends AbstractTableModel {
	
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

	public SchedulerListDataTable(List<Scheduler> schedulers) {
		super();
		this.schedulers = schedulers;
	}

	/**/
	private static final long serialVersionUID = 1L;
	
	List<Scheduler> schedulers;
	String columnList[] = new String[] { "ID", "From Date", "Due Date", "Due Amount", "Total Due" };

	@Override
	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public int getRowCount() {
		return schedulers != null ? schedulers.size() : 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Scheduler entity = schedulers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return DATE_FORMAT.format(entity.getFromDate());
		case 2:
			return DATE_FORMAT.format(entity.getDueDate());
		case 3:
			return entity.getDueAmount();
		case 4:
			return entity.getTotalDue();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnList[col];
	}

}
