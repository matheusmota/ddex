/**
 * 
 */
package java.br.unicamp.ic.lis.ddex.spreadsheet;

/**
 * @author matheus
 * 
 */
public class Sheet {

	private long index = -1;
	private long numberOfRows = -1;
	private long numberOfLines = -1;
	private long lastColumnNumber = -1;
	private long lastRowNumber = -1;
	private String label;
	private boolean isProtected = false;

	public long getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(long numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public long getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLines(long numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public long getLastColumnNumber() {
		return lastColumnNumber;
	}

	public void setLastColumnNumber(long lastColumnNumber) {
		this.lastColumnNumber = lastColumnNumber;
	}

	public long getLastRowNumber() {
		return lastRowNumber;
	}

	public void setLastRowNumber(long lastRowNumber) {
		this.lastRowNumber = lastRowNumber;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public long getIndex() {
		return index;
	}

	public Sheet(long index) {
		this.index = index;
	}

}
