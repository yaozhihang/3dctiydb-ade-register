package org.citydb.plugins.ade_manager.gui.table.schemaTable;

import org.citydb.plugins.ade_manager.gui.table.TableRowDefaultImpl;

public class SchemaRow extends TableRowDefaultImpl {
	private static String[] columnNames;
	private String namespace = "";

	public static String[] getColumnNames() {
		if (columnNames == null) {
			columnNames = new String[1];
			columnNames[0] = "Namespace";
		}
		return columnNames;
	}
	
	public SchemaRow(String namespace) {
		this.namespace = namespace;
	}

	public String getValue(int col) {
		switch (col) {
		case 0:
			return namespace;
		default:
			return "";
		}
	}

	public void setValues(String namespace) {
		this.namespace = namespace;
	}

	public void setValue(int col, Object obj) {
		switch (col) {
		case 0:
			namespace = (String) obj;
			return;
		}
	}
}
