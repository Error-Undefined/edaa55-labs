import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;
import java.util.Random;

public class LineDrawing {
	public static void main(String[] args) {
		int x, y;
		SimpleWindow whatasave = new SimpleWindow(500, 500, "LineDrawing");
		whatasave.waitForMouseClick();
		x = whatasave.getMouseX();
		y = whatasave.getMouseY();
		whatasave.moveTo(x, y);
		while (true) {
			Random rand = new Random();
			// w.waitForMouseClick();
			// x=w.getMouseX();
			// y=w.getMouseY();
			x = rand.nextInt(500);
			y = rand.nextInt(500);
			whatasave.lineTo(x, y);
			whatasave.moveTo(x, y);
			Color col = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			whatasave.setLineColor(col);
			whatasave.setLineWidth(rand.nextInt(5000));
			// SimpleWindow.delay(10);
			// w.waitForMouseClick();
			// x=w.getMouseX();
			// y=w.getMouseY();
			x = rand.nextInt(500);
			y = x = rand.nextInt(500);
			whatasave.moveTo(x, y);
		}
	}
}
