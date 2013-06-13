package java.br.unicamp.ic.lis.ddex.spreadsheet;

public class Cell {

	private CellTypes celltype;
	private boolean isLabeled = false;

	public Cell() {

	}

	public CellTypes getCelltype() {
		return celltype;
	}

	public void setCelltype(CellTypes celltype) {
		this.celltype = celltype;
	}

	public boolean isLabeled() {
		return isLabeled;
	}

	public void setLabeled(boolean isLabeled) {
		this.isLabeled = isLabeled;
	}

}
