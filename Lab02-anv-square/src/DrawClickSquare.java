import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class DrawClickSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(1600, 900, "DrawClickSquare");
		Square sq = new Square(800, 450, 100);
		sq.draw(w);
		w.waitForMouseClick();
		int x = w.getMouseX();
		int y = w.getMouseY();
		int x2 = x;
		int y2 = y;
		int dx, dy;

		while (true) {
			w.waitForMouseClick();
			sq.erase(w);
			x = w.getMouseX();
			y = w.getMouseY();
			dx = x - x2;
			dy = y - y2;
			sq.move(dx, dy);
			x2 = x;
			y2 = y;
			sq.draw(w);
		}
	}

}
