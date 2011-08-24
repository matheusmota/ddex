package br.unicamp.ic.lis.ddex.spreadsheet.part;

/**
 * @author matheus
 * 
 */
public class SpreadsheetLine {

	/**
	 * 
	 */
	private int index = -1;
	private int paragraphNumber = -1;

	public SpreadsheetLine(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public int getParagraphNumber() {
		return paragraphNumber;
	}

}
