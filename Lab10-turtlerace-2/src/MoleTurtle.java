public class MoleTurtle extends RaceTurtle {

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}

	public void raceStep() {
		boolean pen = rand.nextBoolean();
		if (pen) {
			penDown();
		} else {
			penUp();
		}
		super.raceStep();
	}

	public String toString() {
		return super.toString() + " - MoleTurtle";
	}

}
