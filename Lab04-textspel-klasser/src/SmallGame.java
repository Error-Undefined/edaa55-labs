
public class SmallGame {

	private static MainStuff game = new MainStuff();// skapar game-objekt
	private static int spelomgangar;// attribut för antal spelongångar

	public static void main(String[] args) {
		rules();
		game();
		stats();
	}

	/**
	 * Visar spelregler, hämtar antal omgångar
	 */
	public static void rules() {
		spelomgangar = game.getSpelomgangar();// hämtar antal spelomgångar
		game.menu();// visar regler
		game.start();// startar spelet
	}

	/**
	 * Main loop för spelet
	 */
	public static void game() {
		for (int i = 1; i <= spelomgangar; i++) {
			int operation = game.randomNumbers();// skapar slumptalen
			if (operation == 1) {// addition
				game.addition();
			} else if (operation == 2) {// subtraktion
				game.subtraction();
			} else {// multiplikation
				game.multiplication();
			}
			game.waitForUser();// väntar på spelaren
		}
	}

	/**
	 * Visar statistik
	 */
	public static void stats() {

		game.showStatistics();
		game.waitForUser();
		game.showFullStatistics();
		game.waitForEnd();
	}
}
