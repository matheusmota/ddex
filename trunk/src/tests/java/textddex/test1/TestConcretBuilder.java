package textddex.test1;

/**
 * 
 */

import br.unicamp.ic.lis.ddex.text.TextDocumentProperties;
import br.unicamp.ic.lis.ddex.text.builder.ITextBuilder;
import br.unicamp.ic.lis.ddex.text.part.Object;
import br.unicamp.ic.lis.ddex.text.part.Page;
import br.unicamp.ic.lis.ddex.text.part.Paragraph;

/**
 * @author matheus
 * 
 */
public class TestConcretBuilder implements ITextBuilder {

	/**
	 * 
	 */
	public TestConcretBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void foundDocumentBegin(TextDocumentProperties textFileProperties) {

		System.out.println(">Found document begin.");
		System.out.println("Page number: " + textFileProperties.getPageNumber());

	}

	@Override
	public void foundParagraphBegin(Paragraph paragraph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void foundCharSequenceBegin(CharSequence charSequence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void foundObject(Object object) {
		System.out.println(" ***Found object***");

	}

	@Override
	public void foundCharSequenceEnd(CharSequence charSequence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void foundParagraphEnd(Paragraph paragraph) {
		// TODO Auto-generated method stub

	}

	@Override
	public void foundPageEnd(Page page) {
		System.out.println(" >Found page end.");

	}

	@Override
	public void foundPageBegin(Page page) {
		System.out.println(" >Found page begin. (index:" + page.getIndex() + ")");

	}

	@Override
	public void foundDocumentEnd(TextDocumentProperties textFileProperties) {
		System.out.println(">Found document end.");

	}

}
