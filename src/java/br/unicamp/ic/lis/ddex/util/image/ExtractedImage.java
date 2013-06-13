package java.br.unicamp.ic.lis.ddex.util.image;

import java.io.FileOutputStream;
import java.io.IOException;

public final class ExtractedImage {

	public static final void writeImage(String pathAndName, byte[] data) {

		// Creating the object from HWPF(Word)to simplify the transformation

		try {

			FileOutputStream out = new FileOutputStream(pathAndName);
			out.write(data);
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
