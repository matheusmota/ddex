package java.br.unicamp.ic.lis.ddex.spreadsheet.director.xls;

import java.br.unicamp.ic.lis.ddex.spreadsheet.CellTypes;
import java.br.unicamp.ic.lis.ddex.spreadsheet.Image;
import java.br.unicamp.ic.lis.ddex.spreadsheet.ReadingStrategies;
import java.br.unicamp.ic.lis.ddex.spreadsheet.Row;
import java.br.unicamp.ic.lis.ddex.spreadsheet.Sheet;
import java.br.unicamp.ic.lis.ddex.spreadsheet.SpreadsheetProperties;
import java.br.unicamp.ic.lis.ddex.spreadsheet.director.ISpreadsheetBuilder;
import java.br.unicamp.ic.lis.ddex.util.image.ByteArrayToFileImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author Matheus Mota
 * @version 1.1.5
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
	private int maxLines, rowIndex;

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

	private CellTypes whatTypeThatCellIs(Object thecell) {
		HSSFCell cell = (HSSFCell) thecell;

		switch (((HSSFCell) cell).getCellType()) {
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

		default:
			return CellTypes.UNKNOWN;
		}
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

	public void build(ISpreadsheetBuilder builder, ReadingStrategies order) {

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
		HSSFCell cell;
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

		for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
			sheetPOI = wb.getSheetAt(sheetIndex);
			rowIndex = 0;
			// now i'm starting call the builder
			String sheetName = wb.getSheetName(sheetIndex);

			//Setting up the new sheet that will be delivered to the builder
			Sheet sheet = new Sheet(sheetIndex);
			sheet.setLabel(sheetName);
			sheet.setProtected(sheetPOI.getProtect());
			sheet.setNumberOfRows(sheetPOI.getPhysicalNumberOfRows());
			sheet.setLastRowNumber(sheetPOI.getLastRowNum());
			sheet.setLastColumnNumber(this.getLastColumnNumber(sheetIndex));
					
			//delivering to the builder
			builder.foundSheet(sheet);
					

			// Let's walk on the page! Row by row and then cell by cell
			rowsIterator = sheetPOI.rowIterator();
			boolean existRow;
			// start walk on the lines!
			rowIndex = 0;

			existRow = rowsIterator.hasNext();
			while (existRow) {

				rowPOI = (HSSFRow) rowsIterator.next();

				if (rowIndex < rowPOI.getRowNum())// i have blank lines!
				{

					while (rowIndex < rowPOI.getRowNum()) {
						
						Row row = new Row(rowIndex);
						row.setEmpty(true);
						builder.foundRow(row);

					}

				}
				// not empty row PAREI AQUI 13junho13
				builder.foundRow(sheetIndex, rowPOI.getRowNum(),
						rowPOI.getPhysicalNumberOfCells());
				maxCells = rowPOI.getLastCellNum();

				rowIndex++;

				// let\B4s walk on the cells!
				cellsIterator = rowPOI.cellIterator();
				boolean haveCells = cellsIterator.hasNext();
				contCells = 0;
				// start walk on the cells!

				while (haveCells) {

					cell = (HSSFCell) cellsIterator.next();

					// if i have not used cells...
					while (contCells < cell.getCellNum()) {
						builder.foundCell(sheetIndex, rowIndex - 1, contCells,
								CellTypes.NOTUSED);

						builder.foundNotUsedCell(sheetIndex, rowIndex - 1,
								contCells);

						builder.foundCellEnd(sheetIndex, rowIndex - 1,
								contCells);

						contCells++;
					}

					// ****************END NOT UNUSED CELL!!*******************

					// The cell exist.. but the text is blank
					if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {

						builder.foundCell(sheetIndex, rowPOI.getRowNum(),
								cell.getCellNum(), whatTypeThatCellIs(cell));

						// get the cell style
						HSSFCellStyle styleAux = cell.getCellStyle();

						// vars to the style
						boolean leftB = false, rightB = false, upB = false, downB = false;
						int leftBType = 0, rightBType = 0, upBType = 0, downBType = 0;

						String backgroundColor = "FFFFFF";
						short backgroundNum;
						String upBColor = "FFFFFF", downBColor = "FFFFFF", leftBColor = "FFFFFF", rightBColor = "FFFFFF";

						if (styleAux.getBorderLeft() != HSSFCellStyle.BORDER_NONE) {
							leftB = true;
							leftBType = CellBorderTypes.BORDER_TYPE_SOLID;
						}

						if (styleAux.getBorderRight() != HSSFCellStyle.BORDER_NONE) {
							rightB = true;
							rightBType = CellBorderTypes.BORDER_TYPE_SOLID;

						}

						if (styleAux.getBorderTop() != HSSFCellStyle.BORDER_NONE) {
							upB = true;
							upBType = CellBorderTypes.BORDER_TYPE_SOLID;

						}

						if (styleAux.getBorderBottom() != HSSFCellStyle.BORDER_NONE) {
							downB = true;
							downBType = CellBorderTypes.BORDER_TYPE_SOLID;

						}

						// taking the color pallete
						HSSFPalette palleteAux = wb.getCustomPalette();

						// background number
						backgroundNum = styleAux.getFillForegroundColor();

						// background RGB and convert

						if (backgroundNum != 64) {
							backgroundColor = palleteAux
									.getColor(backgroundNum).getHexString();
							backgroundColor = this
									.convertToRGB(backgroundColor);
						}

						// borders colors
						short borderColorNumAux = 0;

						if (rightB) {
							borderColorNumAux = styleAux.getRightBorderColor();
							rightBColor = palleteAux
									.getColor(borderColorNumAux).getHexString();
							rightBColor = this.convertToRGB(rightBColor);

						}

						if (leftB) {
							borderColorNumAux = styleAux.getLeftBorderColor();
							leftBColor = palleteAux.getColor(borderColorNumAux)
									.getHexString();
							leftBColor = this.convertToRGB(leftBColor);
						}

						if (upB) {
							borderColorNumAux = styleAux.getTopBorderColor();
							upBColor = palleteAux.getColor(borderColorNumAux)
									.getHexString();
							upBColor = this.convertToRGB(upBColor);
						}

						if (downB) {
							borderColorNumAux = styleAux.getBottomBorderColor();
							downBColor = palleteAux.getColor(borderColorNumAux)
									.getHexString();
							downBColor = this.convertToRGB(downBColor);
						}

						int align = cell.getCellStyle().getAlignment();
						int alignType;
						switch (align) {
						case HSSFCellStyle.ALIGN_CENTER:
							alignType = CellAlignTypes.ALIGN_TYPE_CENTER;
							break;

						case HSSFCellStyle.ALIGN_JUSTIFY:
							alignType = CellAlignTypes.ALIGN_TYPE_JUSTIFY;
							break;

						case HSSFCellStyle.ALIGN_LEFT:
							alignType = CellAlignTypes.ALIGN_TYPE_LEFT;
							break;

						case HSSFCellStyle.ALIGN_RIGHT:
							alignType = CellAlignTypes.ALIGN_TYPE_RIGHT;
							break;

						default:
							alignType = CellAlignTypes.ALIGN_TYPE_LEFT;
							break;
						}

						builder.foundCellDesignProperties(sheetIndex,
								rowPOI.getRowNum(), cell.getCellNum(),
								rightBColor, leftBColor, upBColor, downBColor,
								leftB, rightB, upB, downB, leftBType,
								rightBType, upBType, downBType, alignType,
								backgroundColor);

						builder.foundBlankContentInCell(sheetIndex,
								rowPOI.getRowNum(), cell.getCellNum());

						// end of BLANK CELL

					} else {// not a BLANK content cell....

						builder.foundCell(sheetIndex, rowPOI.getRowNum(),
								cell.getCellNum(), whatTypeThatCellIs(cell));

						// get the cell style
						HSSFCellStyle styleAux = cell.getCellStyle();

						if (styleAux != null) {
							// vars to the style
							boolean leftB = false, rightB = false, upB = false, downB = false;
							int leftBType = 0, rightBType = 0, upBType = 0, downBType = 0;

							String textColor = "000000", backgroundColor = "FFFFFF";
							short colorNum, backgroundNum;
							String upBColor = "FFFFFF", downBColor = "FFFFFF", leftBColor = "FFFFFF", rightBColor = "FFFFFF";

							if (styleAux.getBorderLeft() != HSSFCellStyle.BORDER_NONE) {
								leftB = true;
								leftBType = CellBorderTypes.BORDER_TYPE_SOLID;
							}

							if (styleAux.getBorderRight() != HSSFCellStyle.BORDER_NONE) {
								rightB = true;
								rightBType = CellBorderTypes.BORDER_TYPE_SOLID;

							}

							if (styleAux.getBorderTop() != HSSFCellStyle.BORDER_NONE) {
								upB = true;
								upBType = CellBorderTypes.BORDER_TYPE_SOLID;

							}

							if (styleAux.getBorderBottom() != HSSFCellStyle.BORDER_NONE) {
								downB = true;
								downBType = CellBorderTypes.BORDER_TYPE_SOLID;

							}

							// get the font!!
							HSSFFont fontAux = styleAux.getFont(wb);

							// Taking my informations..
							colorNum = fontAux.getColor();

							// taking tha color pallet
							HSSFPalette palletAux = wb.getCustomPalette();

							// text color!
							if (palletAux.getColor(colorNum) != null) {
								textColor = palletAux.getColor(colorNum)
										.getHexString();
								// converting...
								textColor = this.convertToRGB(textColor);
							}
							// background number
							backgroundNum = styleAux.getFillForegroundColor();
							// background RGB and convert
							if (backgroundNum != 64) {
								backgroundColor = palletAux.getColor(
										backgroundNum).getHexString();

								backgroundColor = this
										.convertToRGB(backgroundColor);
							}
							// borders colors
							short borderColorNumAux = 0;

							if (rightB) {
								borderColorNumAux = styleAux
										.getRightBorderColor();
								rightBColor = palletAux.getColor(
										borderColorNumAux).getHexString();
								rightBColor = this.convertToRGB(rightBColor);
							}

							if (leftB) {
								borderColorNumAux = styleAux
										.getLeftBorderColor();
								leftBColor = palletAux.getColor(
										borderColorNumAux).getHexString();
								leftBColor = this.convertToRGB(leftBColor);
							}

							if (upB) {
								borderColorNumAux = styleAux
										.getTopBorderColor();
								upBColor = palletAux
										.getColor(borderColorNumAux)
										.getHexString();
								upBColor = this.convertToRGB(upBColor);
							}

							if (downB) {
								borderColorNumAux = styleAux
										.getBottomBorderColor();
								downBColor = palletAux.getColor(
										borderColorNumAux).getHexString();
								downBColor = this.convertToRGB(downBColor);
							}

							boolean bold = false;
							if ((cell.getCellStyle().getFont(wb)
									.getBoldweight() == HSSFFont.BOLDWEIGHT_BOLD))
								bold = true;

							boolean underline = false;
							if (cell.getCellStyle().getFont(wb).getUnderline() > 0)
								underline = true;

							boolean italic = fontAux.getItalic();

							int align = cell.getCellStyle().getAlignment();
							int alignType;
							switch (align) {
							case HSSFCellStyle.ALIGN_CENTER:
								alignType = CellAlignTypes.ALIGN_TYPE_CENTER;
								break;

							case HSSFCellStyle.ALIGN_JUSTIFY:
								alignType = CellAlignTypes.ALIGN_TYPE_JUSTIFY;
								break;

							case HSSFCellStyle.ALIGN_LEFT:
								alignType = CellAlignTypes.ALIGN_TYPE_LEFT;
								break;

							case HSSFCellStyle.ALIGN_RIGHT:
								alignType = CellAlignTypes.ALIGN_TYPE_RIGHT;
								break;

							default:
								alignType = CellAlignTypes.ALIGN_TYPE_LEFT;
								break;
							}

							// ***STARTING TEXT PROPERTIS****

							builder.foundCellDesignProperties(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum(),
									rightBColor, leftBColor, upBColor,
									downBColor, leftB, rightB, upB, downB,
									leftBType, rightBType, upBType, downBType,
									alignType, backgroundColor);

							int fontSize = fontAux.getFontHeight() / 10;
							String fontName = fontAux.getFontName();
							builder.foundCellTextProperties(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum(),
									fontSize, fontName, textColor, bold,
									italic, underline);

						}

						int typeAux = whatTypeThatCellIs(cell);
						switch (typeAux) {

						case CellTypes.BOOLEAN:
							builder.foundCellContentAsBoolean(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum(),
									cell.getBooleanCellValue());
							break;

						case CellTypes.DOUBLE:
							builder.foundCellContentAsDouble(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum(),
									cell.getNumericCellValue());

							break;

						case CellTypes.FORMULA:
							builder.foundCellContentAsFormula(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum(),
									cell.getCellFormula());
							break;

						case CellTypes.STRING:
							builder.foundCellContentAsString(sheetIndex, rowPOI
									.getRowNum(), cell.getCellNum(), cell
									.getRichStringCellValue().getString());

							break;

						case CellTypes.UNKNOWN:
							builder.foundUnknownCellContent(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum());
							break;

						default:
							builder.foundUnknownCellContent(sheetIndex,
									rowPOI.getRowNum(), cell.getCellNum());
							break;
						}

					}
					builder.foundCellEnd(sheetIndex, rowPOI.getRowNum(),
							cell.getCellNum());
					contCells++;

					// **ALWAYS HERE**
					haveCells = cellsIterator.hasNext();
					// **DO NOT CHAGE THIS! NEVER!

				}// Ending the travel around the cells

				// **ALWAYS ON THE END**
				builder.foundLineEnd(sheetIndex, rowPOI.getRowNum());
				existRow = rowsIterator.hasNext();
				// **DO NOT CHAGE THIS! NEVER!

			}// Ending the travel around the lines

			builder.foundPageEnd(sheetIndex, sheetName);
		}// Ending the for of pages
		builder.foundEndOfSS();
		try {
			theFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void old() {

		// Start walking on the Labeled cells
		for (int y = 0; y < labeledCellsNumber; y++) {

			// Calling the IPresentationBuilder and warning about a new Labeled
			// Cell
			// builder.foundLabeledCell(label, pageNumber, lineNumber,
			// cellNumber, cellType, isDeleted)

			// The HSSF cell on the position Y in the array
			HSSFName LCell = wb.getNameAt(y);

			// Getting the Cell label...
			String label = LCell.getNameName();

			// Getting the Cell status...
			boolean isDeleted = LCell.isDeleted();

			// Getting the Cell page name...
			String cellPageName = LCell.getSheetName();

			// Getting the Cell page index
			int cellPageIndex = wb.getSheetIndex(cellPageName);

			// Getting the Cell Reference...
			String reference = LCell.getReference();

			/*****************************************************
			 * If the cell wasn't deleted, lets get the metadata!*
			 *****************************************************/

			if (!isDeleted) {

				/**
				 * Now we go to explore the REFERENCE and get the informations
				 **/

				// My reference explorer
				ExploreCellReference explorer = new ExploreCellReference(
						reference);

				// **Getting the cell reference informations...**

				// Line number
				int lineNumber = explorer.getLineNumber();

				// Cell number (column)
				int cellNumber = explorer.getCellNumber();

				/**
				 * 
				 * OK!! Thats all i need to get the primary information! Go find
				 * the CELL!
				 * 
				 * **/

				// Calling the IPresentationBuilder and warning about the
				// Labeled cell
				builder.foundLabeledCell(label, cellPageIndex, cellPageName,
						lineNumber, cellNumber);

				/**
				 * Restoring the data! Start the metadata
				 * **/

				// Now, go find the cell! If existe!
				boolean existThisCell = this.existCell(cellPageIndex,
						lineNumber, cellNumber);

				if (existThisCell) {
					HSSFCell theHSSFCell = this.getHSSFCell(cellPageIndex,
							lineNumber, cellNumber);

					switch (theHSSFCell.getCellType()) {

					case HSSFCell.CELL_TYPE_FORMULA: {
						String formula = theHSSFCell.getCellFormula();
						builder.foundLabeledCellAsFormula(cellPageIndex,
								lineNumber, cellNumber, formula);

						break;
					}

					case HSSFCell.CELL_TYPE_NUMERIC: {
						double content = theHSSFCell.getNumericCellValue();
						builder.foundLabeledCellAsDouble(cellPageIndex,
								lineNumber, cellNumber, content);

						break;
					}

					case HSSFCell.CELL_TYPE_STRING: {
						String content = theHSSFCell.getRichStringCellValue()
								.getString();
						builder.foundLabeledCellAsString(cellPageIndex,
								lineNumber, cellNumber, content);

						break;
					}

					default:
						builder.foundUnknowLabeledCell(cellPageIndex,
								lineNumber, cellNumber);

						break;
					}
				} else {// NOT EXIST... IS blank
					builder.foundNotUsedCell(cellPageIndex, lineNumber,
							cellNumber);
				}

				// Warning about the end of a labeled cell!
				builder.foundLabeledCellEnd(cellPageIndex, lineNumber,
						cellNumber);

			}// END if isDeleted
			else {
				builder.foundDeletedLabel(label);
			}
			builder.foundLastLabeledCellEnd();
		}// End of the "FOR" Listing Lcells

	}

}