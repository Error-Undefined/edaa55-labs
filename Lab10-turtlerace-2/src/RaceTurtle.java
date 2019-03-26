import java.util.Random;

public class RaceTurtle extends Turtle {
	
	protected int nbr;
	protected static Random rand;
	
	/**
	 * Skapar en sköldpadda som ska springa i fönstret w och som har startnummer
	 * nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	 */
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr),RaceWindow.getStartYPos(nbr));
		
		this.nbr=nbr;
		penDown();
		left(270);
	}
	
	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal mellan 1 och 6.
	 */
	public void raceStep() {
		int x=rand.nextInt(6)+1;
		forward(x);
	}
	
	public String toString() {
		return "Nummer " + Integer.toString(nbr);
	}
}
