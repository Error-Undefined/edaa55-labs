import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class SpamDraw {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(1600, 900, "k");
		Square sq = new Square(0, 0, 1);
		w.setLineColor(java.awt.Color.red);

		for (int i = 0; i <= 900; i++) {
			for (int j = 0; j < 1600; j++) {
				sq.move(1, 0);
				sq.draw(w);
				if((j+i)%3==0) {
					w.setLineColor(java.awt.Color.blue);
				}
				else if((j+i)%3==1) {
					w.setLineColor(java.awt.Color.green);
				}
				else {
					w.setLineColor(java.awt.Color.red);
				}
			}
			sq.move(-1600, 1);
		}
		
		sq.move(800,450);
		w.sprite();

	}
}
