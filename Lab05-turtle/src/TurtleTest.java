import se.lth.cs.pt.window.SimpleWindow;

/** Enhetstest för Turtle-klassen */
public class TurtleTest {

	private int resultY;
	private SimpleWindow w;
	
	public TurtleTest(SimpleWindow w) {
		this.w = w;
		resultY = 150;
	}

	/** Privat hjälpmetod: skriv ut testresultat. */
	private void reportResult(String label, boolean status) {
		w.moveTo(30, resultY);
		w.setLineColor(status ? java.awt.Color.GREEN.darker() : java.awt.Color.RED);
		w.writeText("##");
		w.setLineColor(java.awt.Color.BLACK);
		w.moveTo(60, resultY);
		w.writeText(label + "  " + (status ? "JA" : "NEJ"));
		resultY += 30;
	}

	/**
	 * Ritar en kvadrat med två sköldpaddor. Om det inte ritas en kvadrat
	 * beror det troligen på att startpositionen i forward() inte sätts
	 * rätt. 
	 */
	private void testTwoTurtles() {
		Turtle t1 = new Turtle(w, 100, 50);
		Turtle t2 = new Turtle(w, 150, 100);

		w.moveTo(30, 30);
		w.writeText("Nedan ska finnas en kvadrat");
		
		t1.penDown();
		t2.penDown();
		
		t1.left(-90);
		t2.left(90);

		t1.forward(50);
		t2.forward(50);
		t1.left(-90);
		t2.left(-90);
		t1.forward(50);
		t2.forward(50);
	}
	
	/**
	 * Samma test som testTwoTurtles, men utan penDown(). Då ska inget ritas.
	 */
	private void testDrawingWithPenUp() {
		Turtle t1 = new Turtle(w, 250, 50);
		Turtle t2 = new Turtle(w, 300, 100);

		w.moveTo(230, 30);
		w.writeText("Nedan ska vara tomt");
		
		t1.left(-90);
		t2.left(90);
		t1.forward(50);
		t2.forward(50);
		t1.left(-90);
		t2.left(-90);
		t1.forward(50);
		t2.forward(50);
	}

	/** Testar att sköldpaddan inledningsvis är riktad rakt uppåt. */
	private void testInitialAngle() {
		Turtle t = new Turtle(w, 0, 0);
		reportResult("Skapas sköldpaddan med riktning rakt uppåt?", (t.getDirection() == 90));
	}

	/** Testar att låta sköldpaddan svänga med left och turnNorth. */
	private void testAngleCalculations() {
		Turtle t = new Turtle(w, 0, 0);
		t.left(45);
		t.left(-90);
		t.left(180);
		int angle1 = t.getDirection();
		t.turnNorth();
		int angle2 = t.getDirection(); 
		reportResult("Kan sköldpaddan svänga åt vänster och höger?", (angle1 == 225 && angle2 == 90));
	}

	/** Testar att sköldpaddans koordinater beskrivs med double-precision. */
	private void testPrecision() {
		w.moveTo(430, 30);
		w.writeText("Nedan ska finnas en cirkel");

		Turtle t = new Turtle(w, 570, 120);
		t.penDown();
		for (int i = 0; i < 360; i++) {
			t.forward(1);
			t.left(1);
		}
		int x = t.getX();
		int y = t.getY();
		reportResult("Har sköldpaddans koordinater god precision?", (x == 570 && y == 120));
	}

	private void testJumpTo(){
		Turtle t =  new Turtle(w, 0, 0);
		t.jumpTo(120, 120);
		reportResult("Vet sköldpaddan var den är efter att den hoppat?", (t.getX()==120 && t.getY()==120));
	}
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(650, 300, "TurtleTest");
		TurtleTest tester = new TurtleTest(w);
		
		tester.testTwoTurtles();
		tester.testDrawingWithPenUp();
		tester.testInitialAngle();
		tester.testAngleCalculations();
		tester.testPrecision();
		tester.testJumpTo();
	}
}
