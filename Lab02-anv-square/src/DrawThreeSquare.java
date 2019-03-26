import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;
import java.util.Random;

public class DrawThreeSquare {
	public static void main(String[] args) {
		Random rand = new Random();
		SimpleWindow w = new SimpleWindow(600, 600, "DrawSquare");
		
		while(true) {
		int dx1=rand.nextInt(200)+5;
		int dy1=rand.nextInt(200)+5;
		int dx2=rand.nextInt(200)+5;
		int dy2=rand.nextInt(200)+5;
		
		w.clear();
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		sq.move(dx1,dy1);
		sq.draw(w);
		sq.move(dx2,dy2);
		sq.draw(w);
		w.waitForMouseClick();
		}
	}
}
