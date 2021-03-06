package br.unicamp.ic.lis.ddex.tests.spreadsheet;

import java.io.IOException;

import br.unicamp.ic.lis.ddex.spreadsheet.ReadingStrategies;
import br.unicamp.ic.lis.ddex.spreadsheet.director.xls.XLSReader;
import br.unicamp.ic.lis.ddex.tests.spreadsheet.concretebuilder.ConsolePrinterConcreteBuilder;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// XLS Reader
		XLSReader xlsreader = new XLSReader(
				"/home/lis/matheus/Desktop/PlanilhaTest1.xls");

		ConsolePrinterConcreteBuilder consolePrinter = new ConsolePrinterConcreteBuilder();

		try {
			xlsreader.build(consolePrinter, ReadingStrategies.RowAndCell);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
