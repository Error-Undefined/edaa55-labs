import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	private double x;// läge i x-led
	private double y;// läge i y-led
	private int angle;// vinkel från x-axeln motsols
	private boolean penStatus;// true om pennan är nere

	private SimpleWindow w;// attribut för fönsterobjekt

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.angle = 90;
		this.penStatus = false;
		this.w = w;

		w.moveTo(x, y);
	}

	/** Sänker pennan. */
	public void penDown() {
		penStatus = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		penStatus = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		double x1 = x + n * Math.cos(2 * Math.PI * angle / 360);
		double y1 = y - n * Math.sin(2 * Math.PI * angle / 360);
		w.moveTo((int) Math.round(x), (int) Math.round(y));
		if (penStatus) {
			w.lineTo((int) Math.round(x1), (int) Math.round(y1));
		}
		w.moveTo((int) Math.round(x1), (int) Math.round(y1));
		x = x1;
		y = y1;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		angle += beta;
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo((int) Math.round(x), (int) Math.round(y));
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		angle = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return angle;
	}
}
