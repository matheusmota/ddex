package br.unicamp.ic.lis.ddex.text.builder;

import br.unicamp.ic.lis.ddex.text.TextDocument;
import br.unicamp.ic.lis.ddex.text.TextBlock;
import br.unicamp.ic.lis.ddex.text.TextObject;

public interface ITextBuilder {

	public enum TextBlockTypes {
		PARAGRAPH, PAGE, SECTION, CHAPTER, FOOTNOTE, HEADER
	};

	/**
	 * This method is called when: Director found the begin of a text document.
	 * 
	 * @param TextDocument
	 *            Properties of the file, like full path, size, number of
	 *            letters, number of images, number of styles, metadata etc. <br>
	 * 
	 *            This method is the first to be called in to extraction process
	 *            (see the DDEx tutorial{@link http://code.google.com/p/ddex/})
	 */

	public void foundDocumentBegin(TextDocument textFileProperties);

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
	public void foundTextDocumentEnd(TextDocument textFileProperties);

}