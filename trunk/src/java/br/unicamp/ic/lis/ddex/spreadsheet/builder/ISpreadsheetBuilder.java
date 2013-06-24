package br.unicamp.ic.lis.ddex.spreadsheet.builder;

import br.unicamp.ic.lis.ddex.spreadsheet.Cell;
import br.unicamp.ic.lis.ddex.spreadsheet.Column;
import br.unicamp.ic.lis.ddex.spreadsheet.Row;
import br.unicamp.ic.lis.ddex.spreadsheet.Sheet;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetObject;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetProperties;

public interface ISpreadsheetBuilder {

	public enum SpreadsheetObjectTypes {
		PARAGRAPH, PAGE, SECTION, CHAPTER, FOOTNOTE, HEADER
	};

	/**
	 * This method is called when: Director found the begin of a spreadsheet
	 * document.
	 * 
	 * @param TextDocument
	 *            Properties of the file, like full path, size, number of
	 *            letters, number of images, number of styles, metadata etc. <br>
	 * 
	 *            This method is the first to be called in to extraction process
	 *            (see the DDEx tutorial{@link http://code.google.com/p/ddex/})
	 */

	public void foundDocumentBegin(SpreadsheetProperties spreadsheetDocument);

	/**
	 * This method is called when: Director found sheet in a document (a
	 * spreadsheet document may have many sheets inside)
	 * 
	 * @param
	 */

	public void foundSheet(Sheet block);

	/**
	 * This method is called when: Director found a line (if the extractor is
	 * driven by lines)
	 * 
	 * @param
	 */

	public void foundRow(Row sheetRow);

	/**
	 * This method is called when: Director found a column (if the extractor is
	 * driven by columns)
	 * 
	 * @param
	 */

	public void foundColumn(Column sheetColumn);

	/**
	 * This method is called when: Director found a object, such as images,
	 * tables, links etc.
	 * 
	 * @param
	 */

	public void foundCell(Cell sheetCell);

	/**
	 * This method is called when: Director found a object, such as images,
	 * tables, hyperlynks etc.
	 * 
	 * @param
	 */

	public void foundObject(SpreadsheetObject object);

	/**
	 * This method is called when: Director found sheet in a document (a
	 * spreadsheet document may have many sheets inside)
	 * 
	 * @param
	 */

	public void foundDocumentEnd(SpreadsheetProperties spreadsheetDocument);

}