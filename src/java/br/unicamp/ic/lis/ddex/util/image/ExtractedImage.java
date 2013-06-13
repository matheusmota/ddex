package java.br.unicamp.ic.lis.ddex.util.image;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.hwpf.usermodel.Picture;

public final class ExtractedImage {

	public static final void writeImage(String pathAndName, byte[] dataFrom) {

		// Creating the object from HWPF(Word)to simplify the transformation
		EscherBlipRecord bliprecord = new EscherBlipRecord();
		
		Picture image = new Picture(dataFrom);

		// My conversor from ByteArrayToFileImage type
		ByteArrayToFileImage out = new ByteArrayToFileImage();

		try {

			// My Stream to the new File
			OutputStream stream;

			// Converting the byteArray to FileImage
			stream = out.convert(pathAndName, dataFrom);

			// Recreating the file!!
			image.writeImageContent(stream);

			// Closing Stream...
			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
