import se.lth.cs.pt.window.SimpleWindow;

public class TurtleDrawSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();
		for (int i = 0; i <= 3; i++) {
			t.forward(100);
			t.left(90);
		}
	}
}
