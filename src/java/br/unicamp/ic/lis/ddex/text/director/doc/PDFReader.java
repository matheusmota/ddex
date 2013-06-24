package br.unicamp.ic.lis.ddex.text.director.doc;

import br.unicamp.ic.lis.ddex.text.builder.ITextBuilder;

public class PDFReader {

	// Document full path
	private String documentFullPath;

	// The .ODT document as a object from the adopted ODT reader API
	private String doc = null;

	// Flag and counter for images (document contains images? how many?)
	private boolean havePicture = false;
	private int imageCount = 0;

	public PDFReader(String filePath) throws Exception {

		this.documentFullPath = filePath;
		this.doc = null;

	}

	public void build(ITextBuilder theBuilder) throws Exception {

	}
}
