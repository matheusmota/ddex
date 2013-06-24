/**
 * 
 */
package br.unicamp.ic.lis.ddex.spreadsheet;

import br.unicamp.ic.lis.ddex.common.DocumentObject;

/**
 * @author matheus
 * 
 */
public class SpreadsheetObject extends DocumentObject {

	private ObjectTypes type;

	public SpreadsheetObject(ObjectTypes type) {
		this.type = type;
	}

	public ObjectTypes getType() {
		return this.type;
	}

}
