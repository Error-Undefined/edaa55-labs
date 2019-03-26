import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TwooTurtle {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(1600, 900, "Turtle");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);

		while (distance(t1, t2)) {
			walk(t1);
			walk(t2);
		}
	}

	public static void walk(Turtle t) {
		Random rand = new Random();
		int randomAngle = rand.nextInt(361) - 180;
		int randomStep = rand.nextInt(10) + 1;
		t.penDown();
		t.forward(randomStep);
		t.left(randomAngle);
		t.penUp();
		SimpleWindow.delay(10);
	}

	public static boolean distance(Turtle t1, Turtle t2) {
		double xdiff = t1.getX() - t2.getX();
		double ydiff = t1.getY() - t2.getY();
		double distance = Math.sqrt(xdiff * xdiff + ydiff * ydiff);
		if (distance >= 50) {
			return true;
		} else {
			return false;
		}
	}
}
