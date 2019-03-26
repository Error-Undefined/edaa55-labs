public class AbsentMindedTurtle extends RaceTurtle {

	private int borta;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);

		this.borta = rand.nextInt(99) + 1;
	}

	public void raceStep() {
		int x = rand.nextInt(100) + 1;
		if (x > borta) {
			super.raceStep();
		}
	}

	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + borta + "% frånvarande)";
	}

}