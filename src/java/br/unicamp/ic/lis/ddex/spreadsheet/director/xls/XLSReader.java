package br.unicamp.ic.lis.ddex.spreadsheet.director.xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Comment;

import br.unicamp.ic.lis.ddex.spreadsheet.Cell;
import br.unicamp.ic.lis.ddex.spreadsheet.CellAlignTypes;
import br.unicamp.ic.lis.ddex.spreadsheet.CellTypes;
import br.unicamp.ic.lis.ddex.spreadsheet.Image;
import br.unicamp.ic.lis.ddex.spreadsheet.ReadingStrategies;
import br.unicamp.ic.lis.ddex.spreadsheet.Row;
import br.unicamp.ic.lis.ddex.spreadsheet.RowTypes;
import br.unicamp.ic.lis.ddex.spreadsheet.Sheet;
import br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetProperties;
import br.unicamp.ic.lis.ddex.spreadsheet.builder.ISpreadsheetBuilder;
import br.unicamp.ic.lis.ddex.util.image.ByteArrayToFileImage;

/**
 * @author Matheus Mota
 */
public class XLSReader {

	//
	SpreadsheetProperties document;
	// Document full path
	private String fullpath;

	// My Stream to the file
	private FileInputStream theFile;

	// The POI file system
	private POIFSFileSystem fs;

	// My XLS document
	private HSSFWorkbook wb = null;

	// Last/count cells
	private int maxCells, contCells;

	// Last/count lines
	private int maxLines;

	public XLSReader(String filePath) {
		try {
			fullpath = filePath;
			theFile = new FileInputStream(fullpath);
			fs = new POIFSFileSystem(theFile);
			wb = new HSSFWorkbook(fs);

		} catch (FileNotFoundException e) {
			System.out.println(getClass().getName() + "Says: File not found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println(getClass().getName() + "Says: IOException");
			e.printStackTrace();

		}

	}

	private int getNumberOfSheets() {
		return wb.getNumberOfSheets();
	}

	private CellTypes whatTypeThatCellIs(HSSFCell theCell) {

		switch (theCell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			return CellTypes.DOUBLE;

		case HSSFCell.CELL_TYPE_BLANK:
			return CellTypes.BLANK;

		case HSSFCell.CELL_TYPE_STRING:
			return CellTypes.STRING;

		case HSSFCell.CELL_TYPE_BOOLEAN:
			return CellTypes.BOOLEAN;

		case HSSFCell.CELL_TYPE_FORMULA:
			return CellTypes.FORMULA;
		}
		return CellTypes.UNKNOWN;
	}

	private Boolean existCell(int pageRequested, int lineRequested,
			int cellRequested) {

		HSSFSheet sheet = wb.getSheetAt(pageRequested);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						return true;

			}

		}

		return false;

	}

	private Double getCellAsDouble(int page, int lineRequested,
			int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

							return cell.getNumericCellValue();
						}

			}

		}
		// default result
		return null;

	}

	private Float getCellAsFloat(int page, int lineRequested, int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

							return (float) cell.getNumericCellValue();
						}

			}

		}

		return null;
	}

	@SuppressWarnings("unused")
	private String getCellAsFormula(int page, int lineRequested,
			int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {

							return cell.getCellFormula();
						}

			}

		}

		return null;
	}

	private Integer getCellAsInt(int page, int lineRequested, int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

							return (int) cell.getNumericCellValue();
						}

			}

		}

		return null;

	}

	private Object getCellAsObject(int page, int lineRequested,
			int cellRequested) {

		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_BLANK:
							return "";
						case HSSFCell.CELL_TYPE_BOOLEAN:
							return cell.getBooleanCellValue();
						case HSSFCell.CELL_TYPE_FORMULA:
							return cell.getCellFormula();
						case HSSFCell.CELL_TYPE_NUMERIC:
							return (Float) (float) cell.getNumericCellValue();
						case HSSFCell.CELL_TYPE_STRING:
							return cell.getStringCellValue();
						case HSSFCell.CELL_TYPE_ERROR:
							return null;

						default:
							return null;

						}

					}
			}

		}

		return null;
	}

	private String getCellAsString(int page, int lineRequested,
			int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {

							HSSFCellStyle stilo = cell.getCellStyle();

							return cell.getRichStringCellValue().getString();

						}

			}

		}

		return null;

	}

	private CellTypes getCellType(int page, int lineRequested, int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested) {
						return this.whatTypeThatCellIs(cell);
					}
			}

		}

		return CellTypes.BLANK;
	}

	private int getLastColumnNumber(int page) {

		int contColumn = -1;

		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();
				if (cell.getCellNum() > contColumn) {
					contColumn = cell.getCellNum();

				}

			}

		}

		if (contColumn == -1)
			return 0;
		else
			return contColumn;
	}

	private int getLastLineNumber(int page) {
		HSSFSheet sheet = wb.getSheetAt(page);
		return sheet.getLastRowNum();
	}

	private String convertToRGB(String fullRGB) {

		char result[] = new char[6];

		int walker = 0;
		int car = 0;
		int contZeros = 0;
		int contQuad = 0;

		if (fullRGB.equals("0:0:0"))
			return "000000";
		else {

			for (int x = 0; x <= 1; x++)
				if ((fullRGB.charAt(walker) == '0')
						&& (fullRGB.charAt(walker + 1) == ':')) {
					result[car] = '0';
					result[car + 1] = '0';

					walker += 2;
					car += 2;
					contZeros++;
				} else {
					result[car] = fullRGB.charAt(walker);
					result[car + 1] = fullRGB.charAt(walker + 1);

					walker += 5;
					car += 2;
					contQuad++;
				}

			if ((fullRGB.toCharArray().length) == 14) {
				result[4] = fullRGB.charAt(10);
				result[5] = fullRGB.charAt(11);
			}
			if (((fullRGB.toCharArray().length) == 8) && (contZeros == 2)) {
				result[4] = fullRGB.charAt(4);
				result[5] = fullRGB.charAt(5);
			}

			if (((fullRGB.toCharArray().length) == 11) && (contZeros == 1)) {
				result[4] = fullRGB.charAt(7);
				result[5] = fullRGB.charAt(8);
			}

			if (((fullRGB.toCharArray().length) == 11) && (contZeros == 0)) {
				result[4] = '0';
				result[5] = '0';
			}

			if (((fullRGB.toCharArray().length) == 8) && (contZeros == 1)
					&& (contQuad == 1)) {

				if (fullRGB.charAt(6) != ':') {
					result[4] = fullRGB.charAt(6);
					result[5] = fullRGB.charAt(7);
				} else {
					result[4] = '0';
					result[5] = '0';

				}

			}
		}

		return String.valueOf(result);

	}

	private HSSFCell getHSSFCell(int page, int lineRequested, int cellRequested) {
		HSSFSheet sheet = wb.getSheetAt(page);
		Iterator<?> rowsIterator = sheet.rowIterator();

		HSSFRow row;
		HSSFCell cell;

		while (rowsIterator.hasNext()) {

			row = (HSSFRow) rowsIterator.next();
			Iterator<?> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				cell = (HSSFCell) cellIterator.next();

				if (row.getRowNum() == lineRequested)
					if (cell.getCellNum() == cellRequested)
						return cell;

			}

		}

		return null;

	}

	public void build(ISpreadsheetBuilder builder, ReadingStrategies order)
			throws IOException {

		// instantiating a new document properties
		this.document = new SpreadsheetProperties(this.fullpath);

		// setting number of sheets
		int numberOfSheets = getNumberOfSheets();
		this.document.setNumberOfSheets(numberOfSheets);

		// setting number of labeled cells
		int labeledCellsNumber = wb.getNumberOfNames();
		this.document.setNumberOfLabeledCells(labeledCellsNumber);

		// Walking on sheets
		// Objects that will iterate overrows and cells
		HSSFSheet sheetPOI;
		HSSFRow rowPOI;
		HSSFCell cellPOI;
		Iterator<?> rowsIterator = null;
		Iterator<?> cellsIterator = null;

		/********************** Objects Extraction block - Images **********************/

		// My list of images (As Byte Array)
		List imgList;

		// Copying the original list of images from workbook
		imgList = wb.getAllPictures();

		// setting number of images
		int numberofImages = imgList.size();
		this.document.setNumberOfImages(numberofImages);

		builder.foundDocumentBegin(this.document);

		// My convesor from ByteArray To FileImage type
		ByteArrayToFileImage out = new ByteArrayToFileImage();

		/**********************************************
		 ********** Image Table (Walking...)***********
		 **********************************************/

		int imageCount = 0;
		List<HSSFPictureData> lst = wb.getAllPictures();
		for (Iterator<HSSFPictureData> it = lst.iterator(); it.hasNext();) {
			imageCount++;

			// Getting the image as Data (ByteArray)
			HSSFPictureData pict = it.next();

			// Creating the object from HWPF(Word)to simplify the transformation
			byte[] data = pict.getData();

			// Image name (Suggested)
			String sugestedImageName = "" + imageCount;

			// Image extension (Suggested)
			String sugestedImageExtension = pict.suggestFileExtension();

			// Make a new object for properties
			Image image = new Image();
			image.setName(sugestedImageName);
			image.setExtension(sugestedImageExtension);

			// warning the builder about the image
			builder.foundObject(image);

		}

		int sheetIndex, rowIndex, cellIndex;
		for (sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
			sheetPOI = wb.getSheetAt(sheetIndex);
			rowIndex = 0;
			// now i'm starting call the builder
			String sheetName = wb.getSheetName(sheetIndex);

			// Setting up the new sheet that will be delivered to the builder
			Sheet sheet = new Sheet(sheetIndex);
			sheet.setLabel(sheetName);
			sheet.setProtected(sheetPOI.getProtect());
			sheet.setNumberOfRows(sheetPOI.getPhysicalNumberOfRows());
			sheet.setLastRowNumber(sheetPOI.getLastRowNum());
			sheet.setLastColumnNumber(this.getLastColumnNumber(sheetIndex));

			// delivering to the builder
			builder.foundSheet(sheet);

			/**
			 * PAGE Walker starts here. Let's walk on the page! Row by row and
			 * then cell by cell
			 */

			// start walk on the rows
			rowsIterator = sheetPOI.rowIterator();
			boolean existRow;
			rowIndex = 0;
			existRow = rowsIterator.hasNext();
			Row row;
			Cell cell;

			while (existRow) {

				rowPOI = (HSSFRow) rowsIterator.next();

				// i have blank rows!
				if (rowIndex < rowPOI.getRowNum()) {

					while (rowIndex < rowPOI.getRowNum()) {
						row = new Row(sheetIndex, rowIndex);
						row.setRowType(RowTypes.EMPTY);
						builder.foundRow(row);
						rowIndex++;
					}

				}
				// not empty row
				row = new Row(sheetIndex, rowPOI.getRowNum());
				long numberOfCells = rowPOI.getPhysicalNumberOfCells();
				maxCells = rowPOI.getLastCellNum();
				row.setNumberOfCells(numberOfCells);
				row.setLastCellIndex(maxCells);

				// warning builder about the
				builder.foundRow(row);

				// let's walk on the cells!
				cellsIterator = rowPOI.cellIterator();
				boolean haveCells = cellsIterator.hasNext();
				contCells = 0;
				// start walk on the cells!
				cellIndex = 0;
				while (haveCells) {

					cellPOI = (HSSFCell) cellsIterator.next();

					// if i have not used cells...
					while (cellIndex < cellPOI.getColumnIndex()) {
						cell = new Cell(sheetIndex, rowIndex, cellIndex,
								cellIndex, CellTypes.NOTUSED);
						builder.foundCell(cell);
						cellIndex++;
					}

					// ****************END NOT UNUSED CELL!!*******************

					// The cell exist.. but the text is blank
					if (cellPOI.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						cell = new Cell(sheetIndex, rowIndex, cellIndex,
								cellIndex, whatTypeThatCellIs(cellPOI));
						cell.setCellType(CellTypes.BLANK);

						// get the cell style
						HSSFCellStyle styleAux = cellPOI.getCellStyle();

						int align = cellPOI.getCellStyle().getAlignment();
						CellAlignTypes alignType;
						switch (align) {
						case HSSFCellStyle.ALIGN_CENTER:
							alignType = CellAlignTypes.CENTER;
							break;

						case HSSFCellStyle.ALIGN_JUSTIFY:
							alignType = CellAlignTypes.JUSTIFY;
							break;

						case HSSFCellStyle.ALIGN_LEFT:
							alignType = CellAlignTypes.LEFT;
							break;

						case HSSFCellStyle.ALIGN_RIGHT:
							alignType = CellAlignTypes.RIGHT;
							break;

						default:
							alignType = CellAlignTypes.LEFT;
							break;
						}

						cell.setCellAlignType(alignType);

						//
						builder.foundCell(cell);

						// end of BLANK CELL

					} else {// not a BLANK content cell....

						cell = new Cell(sheetIndex, rowIndex, cellIndex,
								cellIndex, whatTypeThatCellIs(cellPOI));

						// get the cell style
						HSSFCellStyle styleAux = cellPOI.getCellStyle();

						if (styleAux != null) {
							// vars to the style
							boolean leftB = false, rightB = false, upB = false, downB = false;
							int leftBType = 0, rightBType = 0, upBType = 0, downBType = 0;

							String textColor = "000000", backgroundColor = "FFFFFF";
							short colorNum, backgroundNum;
							String upBColor = "FFFFFF", downBColor = "FFFFFF", leftBColor = "FFFFFF", rightBColor = "FFFFFF";

							// if (styleAux.getBorderLeft() !=
							// HSSFCellStyle.BORDER_NONE) {
							// leftB = true;
							// leftBType = CellBorderTypes.BORDER_TYPE_SOLID;
							// }
							//
							// if (styleAux.getBorderRight() !=
							// HSSFCellStyle.BORDER_NONE) {
							// rightB = true;
							// rightBType = CellBorderTypes.BORDER_TYPE_SOLID;
							//
							// }
							//
							// if (styleAux.getBorderTop() !=
							// HSSFCellStyle.BORDER_NONE) {
							// upB = true;
							// upBType = CellBorderTypes.BORDER_TYPE_SOLID;
							//
							// }
							//
							// if (styleAux.getBorderBottom() !=
							// HSSFCellStyle.BORDER_NONE) {
							// downB = true;
							// downBType = CellBorderTypes.BORDER_TYPE_SOLID;
							//
							// }

							// get the font!!
							HSSFFont fontAux = styleAux.getFont(wb);

							// Taking my informations..
							colorNum = fontAux.getColor();

							// taking tha color pallet
							HSSFPalette palletAux = wb.getCustomPalette();

							// // text color!
							// if (palletAux.getColor(colorNum) != null) {
							// textColor = palletAux.getColor(colorNum)
							// .getHexString();
							// // converting...
							// textColor = this.convertToRGB(textColor);
							// }
							// // background number
							// backgroundNum =
							// styleAux.getFillForegroundColor();
							// // background RGB and convert
							// if (backgroundNum != 64) {
							// backgroundColor = palletAux.getColor(
							// backgroundNum).getHexString();
							//
							// backgroundColor = this
							// .convertToRGB(backgroundColor);
							// }
							// // borders colors
							// short borderColorNumAux = 0;
							//
							// if (rightB) {
							// borderColorNumAux = styleAux
							// .getRightBorderColor();
							// rightBColor = palletAux.getColor(
							// borderColorNumAux).getHexString();
							// rightBColor = this.convertToRGB(rightBColor);
							// }
							//
							// if (leftB) {
							// borderColorNumAux = styleAux
							// .getLeftBorderColor();
							// leftBColor = palletAux.getColor(
							// borderColorNumAux).getHexString();
							// leftBColor = this.convertToRGB(leftBColor);
							// }
							//
							// if (upB) {
							// borderColorNumAux = styleAux
							// .getTopBorderColor();
							// upBColor = palletAux
							// .getColor(borderColorNumAux)
							// .getHexString();
							// upBColor = this.convertToRGB(upBColor);
							// }
							//
							// if (downB) {
							// borderColorNumAux = styleAux
							// .getBottomBorderColor();
							// downBColor = palletAux.getColor(
							// borderColorNumAux).getHexString();
							// downBColor = this.convertToRGB(downBColor);
							// }

							boolean bold = false;
							if ((cellPOI.getCellStyle().getFont(wb)
									.getBoldweight() == HSSFFont.BOLDWEIGHT_BOLD)) {
								bold = true;
							}

							boolean underline = false;
							if (cellPOI.getCellStyle().getFont(wb)
									.getUnderline() > 0) {
								underline = true;
							}

							boolean italic = fontAux.getItalic();

							int align = cellPOI.getCellStyle().getAlignment();
							CellAlignTypes alignType;
							switch (align) {
							case HSSFCellStyle.ALIGN_CENTER:
								alignType = CellAlignTypes.CENTER;
								break;

							case HSSFCellStyle.ALIGN_JUSTIFY:
								alignType = CellAlignTypes.JUSTIFY;
								break;

							case HSSFCellStyle.ALIGN_LEFT:
								alignType = CellAlignTypes.LEFT;
								break;

							case HSSFCellStyle.ALIGN_RIGHT:
								alignType = CellAlignTypes.RIGHT;
								break;

							default:
								alignType = CellAlignTypes.LEFT;
								break;
							}

							int fontSize = fontAux.getFontHeight() / 10;
							String fontName = fontAux.getFontName();

							// ***Setting cell info****
							cell.setCellAlignType(alignType);
							cell.setBackgroundColor(backgroundColor);
							cell.setFontSize(fontSize);
							cell.setFontName(fontName);
							cell.setTextColor(textColor);
							cell.setBold(bold);
							cell.setItalic(italic);
							cell.setUnderline(underline);

						}// end style handling

						CellTypes typeAux = whatTypeThatCellIs(cellPOI);
						cell.setCelltype(typeAux);

						switch (typeAux) {

						case BOOLEAN:
							cell.setContent(cellPOI.getBooleanCellValue() + "");
							break;

						case DOUBLE:
							cell.setContent(cellPOI.getNumericCellValue() + "");
							break;

						case FORMULA:
							cell.setContent(cellPOI.getCellFormula() + "");
							break;

						case STRING:
							cell.setContent(cellPOI.getRichStringCellValue()
									.getString());
							break;

						case UNKNOWN:
							cell.setContent(null);
							break;

						}

						Comment comment = cellPOI.getCellComment();

						if (comment != null){
							cell.setComment(comment.getString().getString());
							cell.setCommentAuthor(comment.getAuthor());
							System.out.println("achei comment");
						}
						
						builder.foundCell(cell);

					}

					contCells++;
					// builder.foundcellend(cell);
					// **ALWAYS HERE**
					haveCells = cellsIterator.hasNext();
					cellIndex++;
					// **DO NOT CHAGE THIS! NEVER!

				}// Ending the travel around the cells

				// **ALWAYS ON THE END**
				// builder.foundLineEnd(sheetIndex, rowPOI.getRowNum());
				existRow = rowsIterator.hasNext();
				rowIndex++;
				// **DO NOT CHANGE THIS! NEVER!

			}// Ending the travel around the rows

			// builder.foundPageEnd(sheetIndex, sheetName);
		}// Ending the for of pages
		builder.foundDocumentEnd(this.document);

		theFile.close();

	}

}