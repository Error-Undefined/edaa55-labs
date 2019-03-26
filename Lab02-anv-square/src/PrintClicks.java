import se.lth.cs.pt.window.SimpleWindow;

public class PrintClicks {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClicks");
		while (true) {
			w.waitForMouseClick();
			w.moveTo(w.getMouseX(), w.getMouseY());
			w.writeText("x = " + w.getMouseX() + ", " + "y = " + w.getMouseY());
		}
	}
}
