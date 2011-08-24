package br.unicamp.ic.lis.ddex.textddex.director.pdf;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.unicamp.ic.lis.ddex.textddex.TextDocumentProperties;
import br.unicamp.ic.lis.ddex.textddex.builder.ITextBuilder;
import br.unicamp.ic.lis.ddex.textddex.part.TextObject;
import br.unicamp.ic.lis.ddex.textddex.part.TextPageProperties;

import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

/**
 * @author matheus
 * 
 */
public class PDFReader implements RenderListener {
	StringBuffer list;
	private String fullPath = null;
	private PdfReader reader = null;
	private ITextBuilder builder;

	public PDFReader(String filePath) {
		this.fullPath = filePath;

		// Trying to open the document with the itext pdf reader
		try {
			this.reader = new PdfReader(this.fullPath);

		} catch (IOException e) {
			System.out.println(getClass().getName() + " says: IOException");
			e.printStackTrace();

		}

	}

	public void build(ITextBuilder builder) {
		this.builder = builder;
		list = new StringBuffer();

		// getting page numbers
		int pageNumber = reader.getNumberOfPages();

		byte docMetaData[];
		String metadataSetAsXML;

		try {
			docMetaData = reader.getMetadata();

			if (docMetaData != null) {
				metadataSetAsXML = new String(docMetaData);

				System.out.println("***Metadata File content :***");
				System.out.println(metadataSetAsXML);

				/* writing metadata into an xml file */
				FileOutputStream fos = new FileOutputStream(fullPath + ".xml");
				fos.write(docMetaData);
				fos.close();

				PDFMetadataParser metaParser = new PDFMetadataParser(this.fullPath + ".xml");

			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(getClass().getName() + " says: IOException on metadata xml extraction");

		} /* dumping metadata on the screen */

		PdfReaderContentParser parser = new PdfReaderContentParser(reader);

		try {
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				TextPageProperties currentPageProperties = new TextPageProperties(i);
				this.builder.foundPageBegin(currentPageProperties);

				System.out.println("???"+PdfTextExtractor.getTextFromPage(reader, i, new SimpleTextExtractionStrategy())+"???");
				parser.processContent(1, this);

				this.builder.foundPageEnd(currentPageProperties);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// Instanciating and filling the object that will holds the text file
		// properties
		TextDocumentProperties docProperties = new TextDocumentProperties(this.fullPath, pageNumber);

		// Warning the builder about the document begin
		builder.foundDocumentBegin(docProperties);

		// Warning the builder about the document end
		builder.foundDocumentEnd(docProperties);

		// Closing stream to file reader
		reader.close();
		System.out.println(list);
	}

	// *************************Listener Methods*************************
	@Override
	public void beginTextBlock() {
		System.out.print("|Begin|");

	}

	@Override
	public void endTextBlock() {
		// TODO Auto-generated method stub
		System.out.println("|End|");

	}

	@Override
	public void renderImage(ImageRenderInfo renderInfo) {
		try {
			String filename = this.fullPath + "_" + renderInfo.getRef().getNumber();
			FileOutputStream os;
			PdfImageObject image = renderInfo.getImage();
			PdfName filter = (PdfName) image.get(PdfName.FILTER);
			if (PdfName.DCTDECODE.equals(filter)) {
				os = new FileOutputStream(filename + ".jpg");
				os.write(image.getStreamBytes());
				os.flush();
				os.close();
			} else if (PdfName.JPXDECODE.equals(filter)) {
				os = new FileOutputStream(filename + ".jp2");
				os.write(image.getStreamBytes());
				os.flush();
				os.close();
			} else if (PdfName.JBIG2DECODE.equals(filter)) {
				System.out.println("***********NOT SUPPORTED IMAGE**********");
			} else {
				BufferedImage awtimage = renderInfo.getImage().getBufferedImage();
				if (awtimage != null) {
					ImageIO.write(awtimage, "png", new FileOutputStream(filename + ".png"));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.builder.foundObject(new TextObject());
	}

	@Override
	public void renderText(TextRenderInfo arg0) {
	//	System.out.print(arg0.getText());

		list.append("|" + arg0.getTextRenderMode() + "|");

	}

}
