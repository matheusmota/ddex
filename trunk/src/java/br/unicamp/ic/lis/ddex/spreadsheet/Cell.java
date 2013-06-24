package br.unicamp.ic.lis.ddex.spreadsheet;

public class Cell {

	private long index = -1;
	private long sheetIndex = -1;
	private long rowIndex = -1;
	private long columnIndex = -1;
	private long numberOfCells = 0;
	private long lastCellIndex = 0;
	private boolean isLabeled;
	private boolean isEmpty = true;
	private boolean bold = false;
	private boolean underline = false;
	private boolean italic = false;
	private int fontSize;
	private CellTypes cellType;
	private CellAlignTypes cellAlignType;
	private String fontName;
	private String label;
	private String textColor;
	private String backgroundColor;
	private String content;
	private String comment;
	private String commentAuthor;


	public Cell(long sheetIndex, long rowIndex, long columnIndex, long index,
			CellTypes cellType) {
		this.sheetIndex = sheetIndex;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.index = index;
		this.cellType = cellType;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CellTypes getCellType() {
		return cellType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isUnderline() {
		return underline;
	}

	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public CellAlignTypes getCellAlignType() {
		return cellAlignType;
	}

	public void setCellAlignType(CellAlignTypes cellAlignType) {
		this.cellAlignType = cellAlignType;
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

	public long getLastCellIndex() {
		return lastCellIndex;
	}

	public void setLastCellIndex(long lastCellIndex) {
		this.lastCellIndex = lastCellIndex;
	}



	public void setCellType(CellTypes cellType) {
		this.cellType = cellType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getIndex() {
		return index;
	}

	public long getSheetIndex() {
		return sheetIndex;
	}

	public long getRowIndex() {
		return rowIndex;
	}

	public long getColumnIndex() {
		return columnIndex;
	}


	public void setCelltype(CellTypes cellType) {
		this.cellType = cellType;
	}

	public boolean isLabeled() {
		return isLabeled;
	}

	public void setLabeled(boolean isLabeled) {
		this.isLabeled = isLabeled;
	}

}
