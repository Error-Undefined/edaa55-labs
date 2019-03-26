import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleDrawRandomFigure {
 	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawRandomFigure");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		for (int i = 1; i <= 4; i++) {
			t.forward(rand.nextInt(100));
			SimpleWindow.delay(100);
			t.left(90);
		}
	}
}
