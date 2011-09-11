package java.br.unicamp.ic.lis.ddex.text.builder;

import java.br.unicamp.ic.lis.ddex.text.DocumentProperties;

public interface ITextBuilder {

	/**
	 * This method is called when: Director found the begin of a text document.
	 * 
	 * @param DocumentProperties
	 *            Properties of the file, like full path, size, number of
	 *            letters, number of images, number of styles, metadata etc. <br>
	 * 
	 *            This method is the first to be called in to extraction process
	 *            (see the DDEx tutorial{@link http://ddex.sourceforge.com})
	 */

	public void foundDocumentBegin(DocumentProperties textFileProperties);

	/**
	 * This method is called when: Director found a page
	 * 
	 * @param
	 */

	public void foundPageBegin(Page page);

	/**
	 * This method is called when: Director found a text block, such as section,
	 * subsections, chapters or other block limits
	 * 
	 * @param
	 */

	public void foundBlockBegin(TextBlock block);

	/**
	 * This method is called when: Director found a paragraph
	 * 
	 * @param
	 */

	public void foundParagraphBegin(Paragraph paragraph);

	/**
	 * This method is called when: Director found a char sequence into a
	 * paragraph
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
	 * This method is called when: Director found the end of a paragraph
	 * 
	 * @param
	 */

	public void foundParagraphEnd(Paragraph paragraph);

	/**
	 * This method is called when: Director found the end of a paragraph
	 * 
	 * @param
	 */

	public void foundBlockEnd(TextBlock block);

	/**
	 * This method is called when: Director found the end of a paragraph
	 * 
	 * @param
	 */

	public void foundPageEnd(Page page);

	/**
	 * This method is called when: Director found the end of a text document
	 */
	public void foundTextDocumentEnd(DocumentProperties textFileProperties);

}