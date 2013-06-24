package br.unicamp.ic.lis.ddex.util.image;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayToFileImage {

	public ByteArrayToFileImage() {

	}

	public OutputStream convert(String path, byte[] content) {

		OutputStream stream = null;
		try {
			stream = new FileOutputStream(path);
			stream.write(content);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stream;
	}
}
