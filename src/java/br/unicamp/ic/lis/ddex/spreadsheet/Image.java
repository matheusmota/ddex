package java.br.unicamp.ic.lis.ddex.spreadsheet;

public class Image extends SpreadsheetObject {

	private String name;
	private String extension;
	private int width;
	private int height;
	private int ratioX;
	private int ratioy;

	public Image() {
		super(ObjectTypes.IMAGE);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setRatioX(int ratioX) {
		this.ratioX = ratioX;
	}

	public void setRatioy(int ratioy) {
		this.ratioy = ratioy;
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
