package br.unicamp.ic.lis.ddex.textdex.part;

/**
 * @author matheus
 * 
 */
public class TextPageProperties {

	/**
	 * 
	 */
	private int index = -1;
	private int paragraphNumber = -1;

	public TextPageProperties(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public int getParagraphNumber() {
		return paragraphNumber;
	}

}
