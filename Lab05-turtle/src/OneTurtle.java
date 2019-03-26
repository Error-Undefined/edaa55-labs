import java.util.Random;
import se.lth.cs.pt.window.SimpleWindow;

public class OneTurtle {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(1600, 900, "Turtle");
		Turtle t = new Turtle(w, 800, 450);
		Random rand=new Random();
		int totalSteps=0;
		int randomSteps=0;
		int randomAngle=0;
		while(totalSteps<=1000) {
			randomSteps=rand.nextInt(10)+1;
			t.penDown();
			t.forward(randomSteps);
			randomAngle=rand.nextInt(361)-180;
			t.left(randomAngle);
			totalSteps+=randomSteps;
			SimpleWindow.delay(100);
		}
	}
}
