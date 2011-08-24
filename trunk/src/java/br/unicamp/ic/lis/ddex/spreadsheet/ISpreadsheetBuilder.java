package br.unicamp.ic.lis.ddex.spreadsheet;

import br.unicamp.ic.lis.ddex.spreadsheetdex.part.FloatingObject;
import br.unicamp.ic.lis.ddex.spreadsheetdex.part.SpreadsheetCell;
import br.unicamp.ic.lis.ddex.spreadsheetdex.part.SpreadsheetColumn;
import br.unicamp.ic.lis.ddex.spreadsheetdex.part.SpreadsheetLine;
import br.unicamp.ic.lis.ddex.spreadsheetdex.part.SpreadsheetProperties;
import br.unicamp.ic.lis.ddex.spreadsheetdex.part.SpreadsheetSheet;

/**
 * @author Matheus Mota
 * 
 */

public interface ISpreadsheetBuilder {

	/**
	 * This method is called when: Director found the begin of a text document.
	 * 
	 * @param textFileProperties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */


	public void foundFloatingObject(FloatingObject floatingObjectProperties);

	/**
	 * This method is called when: Director found the begining of the current
	 * page.
	 * 
	 * @param textFileProperties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */
	
	public void foundSpreadsheetBegin(SpreadsheetProperties spreadsheetProperties);

	/**
	 * This method is called when: Director found the begining of the current
	 * page.
	 * 
	 * @param textFileProperties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */
	public void foundSheetBegin(SpreadsheetSheet sheetProperties);

	/**
	 * This method is called when: Director found the beginning of a paragraph
	 * 
	 * @param paragraph
	 *            Represents the paragraph it-self, having the text content and
	 *            some properties, such as style orientation etc.
	 */

	public void foundLineBegin(SpreadsheetLine lineProperties);

	/**
	 * This method is called when: Director found a char sequence into a
	 * paragraph. CharSequences are usually called when the actual properties of
	 * a charSequence is modified
	 * 
	 * @param charSequence
	 *            holds the content and properties of a charSequence
	 */

	public void foundColumnBegin(SpreadsheetColumn columnProperties);

	/**
	 * This method is called when: Director found a image into the char sequence
	 * into a paragraph
	 * 
	 * @param textObject
	 *            holds the properties of the founded object and it self. For
	 *            example, if its a image, the object type will be IMAGE and the
	 *            method getAsImage(); will return the image itself.
	 */

	public void foundCell(SpreadsheetCell cellProperties);

	/**
	 * This method is called when: Director found the end of a char sequence
	 * into a paragraph. For instance, if you are creating aXML, this is a good
	 * time to end your tag (</endcharsequence>). CharSequences are usually
	 * called when the actual properties of a charSequence is modified
	 * 
	 * @param charSequence
	 *            holds the content and properties of a charSequence
	 */

	public void foundColumnEnd(SpreadsheetColumn columnProperties);


	/**
	 * This method is called when: Director found the end of a paragraph
	 * 
	 * @param paragraph
	 *            Represents the paragraph it-self, having the text content and
	 *            some properties, such as style orientation etc.
	 */

	public void foundLineEnd(SpreadsheetLine lineProperties);

	/**
	 * This method is called when: Director found the end of the current page.
	 * 
	 * @param textFileProperties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */
	public void foundSheetEnd(SpreadsheetSheet sheetProperties);


	/**
	 * This method is called when: Director found the end of a text document.
	 * 
	 * @param textFileProperties
	 *            Properties of the text file, like full path, size, number of
	 *            letters, number of images, number of styles, mime-type etc.
	 * 
	 */
	public void foundSpreadsheetEnd(SpreadsheetProperties spreadsheetProperties);
}