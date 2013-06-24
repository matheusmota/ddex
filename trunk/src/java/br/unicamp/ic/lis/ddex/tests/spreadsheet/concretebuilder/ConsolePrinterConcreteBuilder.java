package br.unicamp.ic.lis.ddex.tests.spreadsheettests.concretebuilder;

import br.unicamp.ic.lis.ddex.spreadsheet.Cell;
import br.unicamp.ic.lis.ddex.spreadsheet.Column;
import br.unicamp.ic.lis.ddex.spreadsheet.Row;
import br.unicamp.ic.lis.ddex.spreadsheet.Sheet;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetObject;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetProperties;
import br.unicamp.ic.lis.ddex.spreadsheet.director.ISpreadsheetBuilder;

public class ConsolePrinterConcreteBuilder implements ISpreadsheetBuilder {

	public ConsolePrinterConcreteBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void foundDocumentBegin(SpreadsheetProperties spreadsheetDocument) {
		System.out.println("Found Document Begin");
	}

	@Override
	public void foundSheet(Sheet block) {
		System.out.println("Found Sheet");

	}

	@Override
	public void foundRow(Row sheetRow) {
		System.out.println("Found Row");

	}

	@Override
	public void foundColumn(Column sheetColumn) {
		System.out.println("Found Column");

	}

	@Override
	public void foundCell(Cell sheetCell) {
		System.out.println("Found Cell");

	}

	@Override
	public void foundObject(SpreadsheetObject object) {
		System.out.println("Found Object");

	}

	@Override
	public void foundDocumentEnd(SpreadsheetProperties spreadsheetDocument) {
		System.out.println("Found Document End");

	}

}
