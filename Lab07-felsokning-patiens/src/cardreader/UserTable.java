package cardreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** En tabell av användare. */
public class UserTable {
	/** Maximalt antal användare systemet kan hantera */
	private static final int MAX_USERS = 30000;

	/** Namn på filen som innehåller användardata */
	private static final String FILENAME = "users.txt";

	/** Användare, sorterade efter kortnummer */
	private User[] users;

	/** Antal användare som lagrats i vektorn ovan */
	private int n;

	/** Skapar en användartabell. Innehållet läses in från en fil. */
	public UserTable() {
		users = new User[MAX_USERS];
		n = 0;

		// Filinläsning (baserad på Java snabbreferens)
		Scanner scan = null;
		try {
			scan = new Scanner(new File(FILENAME));
		} catch (FileNotFoundException e) {
			System.out.println("Filen '" + FILENAME + "' kunde inte läsas!");
			System.exit(-1);
		}

		System.out.println("Läser in användardata från " + FILENAME + "...");
		while (scan.hasNextLine()) {
			int nbr = scan.nextInt();
			String name = scan.nextLine();
			name = name.trim(); // städa bort inledande mellanslag
			User u = new User(nbr, name);
			add(u);
		}
		System.out.println("Klar med inläsning av användardata.");
	}

	/**
	 * Lägger in en ny användare. Tabellen hålls sorterad efter kortnummer
	 * (stigande), och användaren läggs in på rätt plats i vektorn. Antalet
	 * användare ökar med 1.
	 */
	public void add(User u) {
		// sätt in användaren på rätt plats i vektorn

		// 1. hitta rätt plats
		int pos = 0;
		while (pos < n && users[pos].getCardNbr() < u.getCardNbr()) {
			pos++;
		}

		// 2. skapa en lucka i vektorn
		for (int i = n; i > pos; i--) {
			users[i] = users[i - 1];
		}

		// 3. stoppa in den nya boken i luckan
		users[pos] = u;
		n++; // fel 1
	}

	/**
	 * Slår upp det givna kortnumret, och returnerar motsvarande användare. Om ingen
	 * sådan användare finns returneras null.
	 * 
	 * Av effektivitetsskäl används binärsökning.
	 */
	public User find(long cardNbr) {
		// binärsökning (baserad på Holm, 2007)

		int low = 0;
		int high = n - 1;
		int mid = -1;
		boolean found = false;

		while (low <= high && !found) { // fel 2
			mid = (low + high) / 2;
			if (users[mid].getCardNbr() == cardNbr) {
				found = true;
			}
			if (users[mid].getCardNbr() > cardNbr) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return found ? users[mid] : null;
	}

	/**
	 * Testmetod för binärsökningen: går igenom alla användare och kollar att deras
	 * kortnummer kan sökas upp. Om något kortnummer inte kunde sökas upp returneras
	 * detta. Annars, om alla sökningar lyckades, returneras 0.
	 */
	public int testFind() {
		for (int i = 0; i < n; i++) {
			int nbr = users[i].getCardNbr();
			User found = find(nbr);
			if (found != users[i]) {
				return nbr;
			}
		}
		return 0;
	}

	/**
	 * Slår upp den användare som har det givna namnet. Om flera sådana användare
	 * finns returneras den första i vektorn. Om ingen sådan användare finns
	 * returneras null.
	 * 
	 * Eftersom denna sökning görs sällan räcker det med linjärsökning.
	 */
	public User findByName(String name) {
		for (int i = 0; i < n; i++) {
			if (users[i].getName().equals(name)) { // fel 3
				return users[i];
			}
		}

		return null;
	}

	/** Skriver ut hela användartabellen. */
	public void print() {
		System.out.println("Tabellens innehåll:");
		System.out.println("-------------------");
		for (int i = 0; i < n; i++) {
			System.out.println(users[i].toString());
		}
		System.out.println("-------------------");
		System.out.println("Totalt " + n + " användare i systemet.");
	}

	/** Returnerar antalet användare i tabellen. */
	public int getNbrUsers() {
		return n;
	}
}
