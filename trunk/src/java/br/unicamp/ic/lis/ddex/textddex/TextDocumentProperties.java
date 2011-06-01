package java.br.unicamp.ic.lis.ddex.textddex;

/**
 * @author matheus
 * 
 */
public class TextDocumentProperties {

	private String filePath = null;

	public TextDocumentProperties(String fPath) {
		this.filePath = fPath;

	}

	/**
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

}
