package textddex.test1;


import br.unicamp.ic.lis.ddex.textddex.director.pdf.PDFReader;

public class Test1Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		PDFReader reader = new PDFReader("/home/lis/matheus/Desktop/t1.pdf");
		
		TestConcretBuilder  concreteBuilder = new TestConcretBuilder();
		
		reader.build(concreteBuilder);
	}

}
