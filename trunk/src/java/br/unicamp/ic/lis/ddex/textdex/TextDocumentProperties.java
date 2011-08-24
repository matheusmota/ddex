package br.unicamp.ic.lis.ddex.textdex;

/**
 * @author matheus
 * 
 */
public class TextDocumentProperties {

	private String filePath = null;

	private String metadataSet="";
	private String author="";
	private String producer="";
	private String title="";
	private String format="";
	private String creationDate="";
	private String subject="";
	private String rights="";
	private String description="";
	
	private int pageNumber = -1;

	private int imageNumber =-1;
	
	private int styleNumber=-1;
	
	public int getPageNumber() {
		return pageNumber;
	}

	public TextDocumentProperties(String fPath, int pageNumber) {
		this.filePath = fPath;
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

}
