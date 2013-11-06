package com.adrianoavelar.util;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class NotEditableTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3283434426727345296L;

	public NotEditableTableModel() {
		// TODO Auto-generated constructor stub
	}

	public NotEditableTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public NotEditableTableModel(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public NotEditableTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public NotEditableTableModel(Vector data, Vector columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public NotEditableTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }

}
