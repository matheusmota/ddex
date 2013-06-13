package java.br.unicamp.ic.lis.ddex.util.image;

import org.apache.poi.hwpf.usermodel.Picture;

public class ImageProperties {

	private String name;
	private String extension;
	private int width;
	private int height;
	private int ratioX;
	private int ratioy;


	public ImageProperties(Picture p) {
		this.name = p.suggestFullFileName();
		this.extension = p.suggestFileExtension();
		this.width = p.getWidth();
		this.height = p.getHeight();
		this.ratioX = p.getAspectRatioX();
		this.ratioy = p.getAspectRatioY();

	}

	public String getName() {
		return name;
	}

	public String getExtension() {
		return extension;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getRatioX() {
		return ratioX;
	}

	public int getRatioy() {
		return ratioy;
	}

}
