/**
 * 
 */
package br.unicamp.ic.lis.ddex.textdex.director.pdf;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author matheus
 *
 */
public class PDFMetadataParser {

	public String metadataSet="";
	public String author="";
	public String producer="";
	public String title="";
	public String format="";
	public String creationDate="";
	public String subject="";
	public String rights="";
	public String description="";
	

	public PDFMetadataParser(String xmlFilePath) {

		try {
			// Create a factory
			DocumentBuilderFactory factory =   DocumentBuilderFactory.newInstance();
			// Use the factory to create a builder
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFilePath);
			// Get a list of all elements in the document
			NodeList list = doc.getElementsByTagName("*");
			System.out.println("XML Elements: ");

			for (int i=0; i<list.getLength(); i++) {
				// Get element
				Element element = (Element)list.item(i);

				if(element.getNodeName().toLowerCase().equals("dc:creator")){
					System.out.println(element.getNodeName()+": "+element.getNodeValue()); 
					this.creationDate=element.getNodeValue();				
					}
				if(element.getNodeName().toLowerCase().equals("pdf:producer")){
					System.out.println(element.getNodeName()+": "+element.getNodeValue()); 
					this.creationDate=element.getNodeValue();				
					}
				if(element.getNodeName().toLowerCase().equals("dc:creator")){
					System.out.println(element.getNodeName()+": "+element.getNodeValue()); 
					this.creationDate=element.getNodeValue();				
					}
				if(element.getNodeName().toLowerCase().equals("dc:creator")){
					System.out.println(element.getNodeName()+": "+element.getNodeValue()); 
					this.creationDate=element.getNodeValue();				
					}
				if(element.getNodeName().toLowerCase().equals("dc:creator")){
					System.out.println(element.getNodeName()+": "+element); 
					this.creationDate=element.getNodeValue();				
					}
				

			}



		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
