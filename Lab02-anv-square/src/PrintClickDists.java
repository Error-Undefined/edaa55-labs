import se.lth.cs.pt.window.SimpleWindow;

public class PrintClickDists {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClickDists");
		int oldX = 0; // x-koordinaten för "förra punkten"
		int oldY = 0; // y-koordinaten
		while (true) {
			w.waitForMouseClick();
			int x = w.getMouseX();
			int y = w.getMouseY();
			w.moveTo(x, y);
			int xDist = x - oldX;
			int yDist = y - oldY;
			w.writeText("Avstånd: " + Math.sqrt(xDist * xDist + yDist * yDist));
			oldX = x;
			oldY = y;
		}
	}
}
