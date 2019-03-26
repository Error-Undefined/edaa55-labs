
public class Graphics {

	private int width; // bredden
	private int height; // höjden
	private int blockSize; // mullvadens bredd

	private SimpleWindow window; // attribut för fönstret

	/**
	 * Skapar ett fönster med bredd width, höjd height, kvadratsida blockSize, i fullskärm om fullscreen är true
	 * 
	 * @param width
	 *            fönstrets bredd
	 * @param height
	 *            fönstrets höjd
	 * @param blockSize
	 *            mullvadens sidstorlek
	 * @param fullscreen
	 *            Boolean för fullskärm
	 */
	public Graphics(int width, int height, int blockSize, boolean fullscreen) {

		this.width = width * blockSize;
		this.height = height * blockSize;
		this.blockSize = blockSize;

		this.window = new SimpleWindow(width * blockSize, height * blockSize, "Block Mole", fullscreen);
	}

	/**
	 * Skapar första kvadraten
	 */
	public void squareStart() {
		window.moveTo(10, 10);
		window.lineTo(10, 20);
		window.lineTo(20, 20);
		window.lineTo(20, 10);
		window.lineTo(10, 10);
	}

	/**
	 * ritar en fylld kvadrat i fönstret window
	 * 
	 * @param x
	 *            övre vänstra x-koordinaten för rutan i nya koordinater
	 * @param y
	 *            övre vänstra y-koordinaten för rutan i nya koordinater
	 */
	public void block(int x, int y, java.awt.Color color) {
		window.setLineColor(color);
		int left = x * blockSize;
		int right = left + blockSize - 1;
		int top = y * blockSize;
		int bottom = top + blockSize - 1;
		for (int row = top; row <= bottom; row++) {
			window.moveTo(left, row);
			window.lineTo(right, row);
		}
	}

	/**
	 * hämtar bredden
	 * 
	 * @return width: bredden i pixlar
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * hämtar höjden
	 * 
	 * @return height: höjden i pixlar
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Ritar en rektangel med en massa parametrar
	 * 
	 * @param x
	 *            övre vänstra x-koordinaten
	 * @param y
	 *            övre vänstra y-koordinaten
	 * @param width
	 *            rektangelns bredd
	 * @param height
	 *            rektangelns höjd
	 * @param c
	 *            rektangelns färg
	 */
	public void rectangle(int x, int y, int width, int height, java.awt.Color c) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				block(xx, yy, c);
			}
		}

	}

	/**
	 * Väntar på ett tangenttryck
	 * 
	 * @return den tryckta tangenten i char
	 */
	public char waitForKey() {
		return window.waitForKey();
	}
}
