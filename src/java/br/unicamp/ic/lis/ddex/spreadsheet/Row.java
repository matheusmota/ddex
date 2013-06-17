package java.br.unicamp.ic.lis.ddex.spreadsheet;

public class Row {

	private long index = -1;
	private boolean isEmpty = false;
	private long numberOfCells = -1;

	public Row(long indexRow) {
		this.index = indexRow;
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
