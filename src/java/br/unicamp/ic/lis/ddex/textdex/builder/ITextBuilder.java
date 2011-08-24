package java.br.unicamp.ic.lis.ddex.textddex.builder;

import java.br.unicamp.ic.lis.ddex.textddex.TextDocumentProperties;
import java.br.unicamp.ic.lis.ddex.textddex.parts.CharSequence;
import java.br.unicamp.ic.lis.ddex.textddex.parts.Paragraph;


/**
 * @author Matheus Mota
 * @category Interface
 */

public interface ITextBuilder {

	/**
	 * This method is called when: Director found the begin of a text document.
	 * 
	 * @param properties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */

	public void foundDocumentBegin(TextDocumentProperties properties);

	/**
	 * This method is called when: Director found the beginning of a paragraph
	 * 
	 * @param paragraph
	 *            Represents the paragraph it-self, having the text content and
	 *            some properties, such as style orientation etc.
	 */

	public void foundParagraphBegin(Paragraph paragraph);

	/**
	 * This method is called when: Director found a char sequence into a
	 * paragraph. CharSequences are usually called when the actual properties of a charSequence is modified
	 *  
	 * @param charSequence holds the content and properties of a charSequence
	 */

	public void foundCharSequenceBegin(CharSequence charSequence);

	/**
	 * This method is called when: Director found a image into the char sequence
	 * into a paragraph
	 * 
	 * @param
	 */

	public void foundObject();

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
	 * This method is called when: Director found the end of a text document
	 */
	public void foundTextDocumentEnd(TextDocumentProperties textFileProperties);

}