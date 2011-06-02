package java.br.unicamp.ic.lis.ddex.textddex.director;

import java.br.unicamp.ic.lis.ddex.textddex.builder.ITextBuilder;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;

/**
 * @author matheus
 * 
 */
public class ODTReader {

	private String fullPath = null;
	private PdfReader reader = null;

	public ODTReader(String filePath) {
		this.fullPath = filePath;

		// Trying to open the document with the itext pdf reader
		try {
			Document doc = new Document();
			this.reader = new PdfReader(this.fullPath);
			doc.open();
		} catch (IOException e) {
			System.out.println(getClass().getName() + " says: IOException");
			e.printStackTrace();

		}

	}

	public void build(ITextBuilder builder) {

	}

}
