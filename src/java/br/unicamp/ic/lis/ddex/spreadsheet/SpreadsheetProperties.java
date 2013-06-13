package java.br.unicamp.ic.lis.ddex.spreadsheet;

public class SpreadsheetProperties {

	private String filePath;
	private String fileName;

	private long numberOfSheets;
	private long filesize;
	private long numberOfWords;
	private long numberOfImages;
	private long NumberOfLabeledCells;

	
	public long getNumberOfLabeledCells() {
		return NumberOfLabeledCells;
	}

	public void setNumberOfLabeledCells(long numberOfLabeledCells) {
		NumberOfLabeledCells = numberOfLabeledCells;
	}

	public SpreadsheetProperties(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setNumberOfSheets(long numberOfSheets) {
		this.numberOfSheets = numberOfSheets;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public void setNumberOfWords(long numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public void setNumberOfImages(long numberOfImages) {
		this.numberOfImages = numberOfImages;
	}

	public long getNumberOfSheets() {
		return numberOfSheets;
	}

	public long getFilesize() {
		return filesize;
	}

	public long getNumberOfWords() {
		return numberOfWords;
	}

	public long getNumberOfImages() {
		return numberOfImages;
	}

}
