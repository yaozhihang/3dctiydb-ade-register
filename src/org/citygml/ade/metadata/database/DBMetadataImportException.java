package org.citygml.ade.metadata.database;

public class DBMetadataImportException extends Exception {

	private static final long serialVersionUID = 6582103092534433232L;
	
	public DBMetadataImportException() {
		super();
	}
	
	public DBMetadataImportException(String message) {
		super(message);
	}
	
	public DBMetadataImportException(Throwable cause) {
		super(cause);
	}
	
	public DBMetadataImportException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
