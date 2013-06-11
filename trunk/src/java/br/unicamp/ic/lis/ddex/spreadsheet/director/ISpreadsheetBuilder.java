package java.br.unicamp.ic.lis.ddex.spreadsheet.director;

import java.br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetDocumentProperties;
import java.br.unicamp.ic.lis.ddex.text.TextDocumentProperties;
import java.br.unicamp.ic.lis.ddex.text.TextBlock;
import java.br.unicamp.ic.lis.ddex.text.TextObject;

public interface ISpreadsheetBuilder {

	public enum TextBlockTypes {
		PARAGRAPH, PAGE, SECTION, CHAPTER, FOOTNOTE, HEADER
	};

	/**
	 * This method is called when: Director found the begin of a spreadsheet document.
	 * 
	 * @param TextDocumentProperties
	 *            Properties of the file, like full path, size, number of
	 *            letters, number of images, number of styles, metadata etc. <br>
	 * 
	 *            This method is the first to be called in to extraction process
	 *            (see the DDEx tutorial{@link http://code.google.com/p/ddex/})
	 */

	public void foundDocumentBegin(SpreadsheetDocumentProperties ssProperties);

	/**
	 * This method is called when: Director found a page
	 * 
	 * @param
	 */

	public void foundBlockBegin(TextBlock block);

	/**
	 * This method is called when: Director found a paragraph
	 * 
	 * @param
	 */

	public void foundCharSequenceBegin(CharSequence charSequence);

	/**
	 * This method is called when: Director found a object, such as images,
	 * tables, hyperlynks etc.
	 * 
	 * @param
	 */

	public void foundObject(TextObject object);

	/**
	 * This method is called when: Director found the end of a char sequence
	 * into a paragraph
	 * 
	 * @param
	 */

	public void foundCharSequenceEnd(CharSequence charSequence);

	/**
	 * This method is called when: Director found the end of a block
	 * 
	 * @param
	 */

	public void foundBlockEnd(TextBlock block);

	/**
	 * This method is called when: Director found the end of a text document
	 */
	public void foundTextDocumentEnd(TextDocumentProperties textFileProperties);

}