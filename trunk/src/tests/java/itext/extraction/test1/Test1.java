/**
 * 
 */
package itext.extraction.test1;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;

/**
 * @author matheus
 *
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fullPath = "/home/lis/matheus/desktop/t1.pdf";

		PdfReader reader=null;
		
		// Trying to open the document with the itext pdf reader
		try {
			reader = new PdfReader(fullPath);
			
			
		} catch (IOException e) {
			System.out.println( "IOException");
			e.printStackTrace();

		}



		//getting page numbers
		int pageNumber = reader.getNumberOfPages();


        byte docMetaData[];
		try {
			docMetaData = reader.getMetadata();
	        String strFileContent = new String(docMetaData); 
	        System.out.println("File content : ");
	        System.out.println(strFileContent);
	        /* writing metadata into an xml file */
	        FileOutputStream fos = new FileOutputStream(fullPath+".xml");
	        fos.write(docMetaData);
	        fos.close();		
			
		} catch (IOException e) {
			e.printStackTrace();
		}  /* dumping metadata on the screen */

	}

}
