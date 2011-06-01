package java.br.unicamp.ic.lis.ddex.textddex.director;

import java.br.unicamp.ic.lis.ddex.textddex.TextDocumentProperties;
import java.br.unicamp.ic.lis.ddex.textddex.builder.ITextBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.StyleDescription;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.CharacterProperties;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.hwpf.usermodel.Picture;

public class DOCReader {
	// Document full path
	private String fullpath;
	private int imageCont = 0;

	// The .DOC document from apache POI
	private HWPFDocument doc = null;

	private boolean havePicture = false;

	public DOCReader(String filePath) {

		this.fullpath = filePath;

		// Try to open the file
		try {

			doc = new HWPFDocument(new FileInputStream(filePath));

		} catch (FileNotFoundException e) {
			System.out.println(getClass().getName() + "Says: File not found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println(getClass().getName() + "Says: IOException");
			e.printStackTrace();

		}

	}

	public void build(ITextBuilder theBuilder) {

		TextDocumentProperties textProperties = new TextDocumentProperties(
				this.fullpath);

		// Starting the process...
		theBuilder.foundDocumentBegin(textProperties);

		/**
		 * Very important variables! Used for all over the program
		 */
		int styleNumber = 0;
		int paragraphNumber = 0;
		int imageNumber = 0;
		StyleSheet style = null;

		/*********************************/

		// Starting get properties e calling theBuilder
		// Getting the document style
		style = doc.getStyleSheet();

		int tempStyleNumber = style.numStyles();

		// Getting how many real styles the document have
		for (int x = 0; x <= tempStyleNumber - 1; x++) {
			if (style.getStyleDescription(x) != null) {
				// Inc number of styles
				styleNumber++;
			}
		}

		//theBuilder.foundStyleNumber(styleNumber);

		// Walking over the styles... And calling the builder!
		for (int x = 0; x <= styleNumber; x++) {

			// Temp variables:
			StyleDescription desc;
			CharacterProperties chp = null;
			ParagraphProperties pap = null;
			int basedStyleId = -1;
			String name = null;

			desc = style.getStyleDescription(x);

			// Here, only the used Styles..
			if (desc != null) {
				chp = desc.getCHP();
				pap = desc.getPAP();
		//		CharSequenceStyle cp = null;// OWN DDex Properties
		//		ParagraphStyle pp = null;// OWN DDex Properties
				name = desc.getName();
				basedStyleId = desc.getBaseStyle();

				boolean isParagraph = false;
				boolean isChar = false;

				// Is paragraph style?
				if (chp != null)
					isChar = true;

				// Is char style?
				if (pap != null)
					isParagraph = true;

				// ParagraphStyle Found!
	//			theBuilder.foundStyle(x, basedStyleId, name, isParagraph, isChar);

				// If i have the char properties:
				if (isChar) {
			//		theBuilder.foundCharStyleProperties(x, basedStyleId, name, cp);
				}
				// If i have the paragraph properties:
				if (isChar) {
			//		theBuilder.foundParagraphStyleProperties(x, basedStyleId,	name, pp);
				}

			}// END IF Exist the style

		}// ENDFOR Walking on the styles.

		/**
		 * PARAGRAPH BLOCK!
		 */
		imageNumber = doc.getPicturesTable().getAllPictures().size();
	//	theBuilder.foundImageNumber(imageNumber);
		int numberParagraph = doc.getRange().numParagraphs();
//		theBuilder.foundParagraphNumber(numberParagraph);
		for (int i = 0; i <= numberParagraph - 1; i++) {
			// POI
			CharacterProperties csPOI = null;
			ParagraphProperties ppPOI = null;
			// DDEx
		//	ParagraphStyle ps = null;
		//	CharSequenceStyle css = null;

			// Getting he full content
			String paragraphContent = doc.getRange().getParagraph(i).text();

			// Unique index to paragraph style
			int pStyleUniqueID = doc.getRange().getParagraph(i).getStyleIndex();

			// Getting name
			String styleName = style.getStyleDescription(pStyleUniqueID)
					.getName();
			// Getting the POIstyle
			ppPOI = style.getParagraphStyle(pStyleUniqueID);

			// DDEx style
		//	ps = new ParagraphStyle(styleName, pStyleUniqueID);

			// Filling the properties of DDEx style
		//	ps = this.fillParagraphStyle(ps, ppPOI);

			// Char sequence...
			int numTextRuns = doc.getRange().getParagraph(i).numCharacterRuns();

			// Ok! I've found a paragraph!
	//		theBuilder.foundParagraph(i, paragraphContent, pStyleUniqueID, ps);

			// Warning about the number of sequences
	//		theBuilder.foundParagraphCharSequenceNumber(numTextRuns);

			/**
			 * CHAR SEQUENCE BLOCK!
			 */
			for (int iChar = 0; iChar < numTextRuns; iChar++) {

				String csContent = doc.getRange().getParagraph(i)
						.getCharacterRun(iChar).text();

				// unique id and name for style
				int uniqueCharStyleID = doc.getRange().getParagraph(i)
						.getCharacterRun(iChar).cloneProperties().getIstd();
				String charStyleName = style.getStyleDescription(
						uniqueCharStyleID).getName();

				csPOI = style.getCharacterStyle(uniqueCharStyleID);

		//		css = new CharSequenceStyle(charStyleName, uniqueCharStyleID);

		//		this.fillCharSequenceStyle(css, csPOI);

				// Testing if its all about a line end
				char firstLetter = csContent.charAt(0);
				int firstletterNumber = (int) firstLetter;
				if ((firstletterNumber != 11) && ((firstletterNumber != 13))
						&& ((firstletterNumber != 7))
						&& ((firstletterNumber != 32))) {
					if (7 == ((int) csContent.charAt(csContent.length() - 1)))
						csContent = csContent.substring(0,
								csContent.length() - 1);
			//		theBuilder.foundCharSequence(i, iChar, csContent,	uniqueCharStyleID, css);
				}

				/**
				 * IMAGE BLOCK!
				 */
				int isPic = doc.getRange().getParagraph(i)
						.getCharacterRun(iChar).getPicOffset();

				if (isPic > -1)
					if (imageNumber > imageCont) {

						Picture p = (Picture) doc.getPicturesTable()
								.getAllPictures().get(imageCont);

				//		theBuilder.foundImage(isPic, p.suggestFullFileName(),p.suggestFileExtension(), p.getContent());
						imageCont++;

					}

			}

		}// END PARAGRAPH WALKER BLOCK

//		theBuilder.foundDocumentEnd();
	}
}
