package br.unicamp.ic.lis.ddex.tests.spreadsheet.concretebuilder;

import br.unicamp.ic.lis.ddex.spreadsheet.Cell;
import br.unicamp.ic.lis.ddex.spreadsheet.Column;
import br.unicamp.ic.lis.ddex.spreadsheet.Row;
import br.unicamp.ic.lis.ddex.spreadsheet.Sheet;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetObject;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetProperties;
import br.unicamp.ic.lis.ddex.spreadsheet.builder.ISpreadsheetBuilder;

public class ConsolePrinterConcreteBuilder implements ISpreadsheetBuilder {

	@Override
	public void foundDocumentBegin(SpreadsheetProperties spreadsheetDocument) {
		System.out.println("Found Document Begin");
	}

	@Override
	public void foundSheet(Sheet sheet) {
		System.out.println("Found Sheet - Index: " + sheet.getIndex());

	}

	@Override
	public void foundRow(Row row) {
		System.out.println("     Found Row - Index: " + row.getIndex() + " ("
				+ row.getRowType() + ")");

	}

	@Override
	public void foundColumn(Column sheetColumn) {
		System.out.println("Found Column");

	}

	@Override
	public void foundCell(Cell cell) {
		System.out.println("          Found Cell - S" + cell.getSheetIndex()
				+ " R" + cell.getRowIndex() + " C" + cell.getIndex()+ " ("
				+ cell.getCelltype() + ")");
		if (cell.getContent() != null)
			System.out.println("                                    Content: " + cell.getContent());

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
