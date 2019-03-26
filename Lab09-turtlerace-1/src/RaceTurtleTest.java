public class RaceTurtleTest {
	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		RaceTurtle r = new RaceTurtle(w, 1);
		
		while(r.getX() < RaceWindow.X_END_POS) {
			r.raceStep();
			RaceWindow.delay(10);
		}
		
		System.out.println("I mål! " + r.toString());
	}
}
