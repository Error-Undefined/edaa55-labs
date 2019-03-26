public class DizzyTurtle extends RaceTurtle {

	private static final double DIZZYNESS_MULTIPLIER = 1.5;

	private int yrsel;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);

		this.yrsel = rand.nextInt(5) + 1;
	}

	public void raceStep() {
		boolean upOrDown = rand.nextBoolean();// true uppåt
		if (upOrDown) {
			this.left((int) Math.pow(DIZZYNESS_MULTIPLIER, yrsel));
		} else {
			this.left(360 - (int) Math.pow(DIZZYNESS_MULTIPLIER, yrsel));
		}
		super.raceStep();
	}

	public String toString() {
		return super.toString() + " - DizzyTurtle (Yrsel: " + yrsel + ")";
	}
}