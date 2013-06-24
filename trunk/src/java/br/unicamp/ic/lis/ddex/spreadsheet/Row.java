package br.unicamp.ic.lis.ddex.spreadsheet;

public class Row {

	private long index = -1;
	private long sheetIndex = -1;
	private boolean isEmpty = false;
	private long numberOfCells = 0;
	private long lastCellIndex = 0;

	public long getLastCellIndex() {
		return lastCellIndex;
	}

	public void setLastCellIndex(long lastCellIndex) {
		this.lastCellIndex = lastCellIndex;
	}

	public Row(long sheetIndex, long indexRow) {
		this.index = indexRow;
		this.sheetIndex = sheetIndex;
	}

	public long getSheetIndex() {
		return sheetIndex;
	}

	public void setSheetIndex(long sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public long getIndex() {
		return index;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public long getNumberOfCells() {
		return numberOfCells;
	}

	public void setNumberOfCells(long numberOfCells) {
		this.numberOfCells = numberOfCells;
	}

}
