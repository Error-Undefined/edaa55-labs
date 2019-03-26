import java.util.Random;
import java.util.Scanner;

public class MainStuff {

	private int spelomgangar;// antal spelomgångar
	private int number1;// tal 1
	private int number2;// tal 2
	private int result;// rätta resultatet
	private String input;// vad som skrevs in
	private int numberInput;// vad som skrevs in omvandlat till int
	
	private int score;// användarens antal rätta svar
	private long totalTime;// totala tiden då användaren har kunnat svara
	// (räknar inte med tiden då systemet väntar på ett entertryck)
	private long trueTotalTime;// Totala tiden det tog för spelaren att komma upp med rätta svar
	private boolean answerType;// true om svaret var rätt, annars false;
	private int[] antalMult;// antal lyckade vs antal frågade multoperationer
	private int[] antalPlus;// antal lyckade vs antal frågade plusoperationer
	private int[] antalMinus;// antal lyckade vs antal frågade minusoperationer

	private Scanner scan;// scannerobjekt

	/*--------- Speloperationer ---------*/

	/**
	 * Skapar ett nytt spel
	 */
	public MainStuff() {
		this.scan = new Scanner(System.in);// definerar scannerobjekt
		
		//initialiserar attribut till 0
		this.score = 0;
		this.totalTime = 0;
		this.trueTotalTime = 0;
		this.antalMult = new int[] { 0, 0 };
		this.antalPlus = new int[] { 0, 0 };
		this.antalMinus = new int[] { 0, 0 };
		
		definePlayAmount();// hur många gånger man vill spela
	}

	/**
	 * Skriver ut spelregler
	 */
	public void menu() {
		consoleLine();
		gameRules();
	}

	/**
	 * Definerar spelreglerna
	 */
	public void gameRules() {
		System.out.println("Spelregler:");
		System.out.println(" ");
		System.out.println("Träna på huvudräkning!");
		System.out.println(" ");
		System.out.println("Välj antal spelomgångar.");
		System.out.println("En slumpmässig operation kommer att visas.");
		System.out.println("Gör den så snabbt som möjligt!");
		System.out.println("Skriver du inte ett heltal får du fel!");
		System.out.println("Statistik visas på slutet.");
	}

	/**
	 * Startar spelet.
	 */
	public void start() {
		waitForUser();
	}

	/*--------- Vänta-satser ---------*/

	/**
	 * Väntar på att användaren trycker på enter
	 */
	public void waitForUser() {
		consoleLine();
		System.out.println("Tryck på enter för att fortsätta.");
		scan.nextLine();
	}

	/**
	 * Väntar på att användaren trycker på enter för att avsluta spelet
	 */
	public void waitForEnd() {
		consoleLine();
		System.out.println("Tryck på enter för att avsluta spelet.");
		scan.nextLine();
	}

	/**
	 * Printar en lång linje
	 */
	public void consoleLine() {
		System.out.println("----------------------------------------");
	}

	/*--------- Taloperationer ---------*/

	/**
	 * Skapar tre slumptal.
	 * 
	 * @return 1: addition, 2: subtraktion, 3: multiplikation
	 */
	public int randomNumbers() {
		Random rand = new Random();
		this.number1 = rand.nextInt(101);
		this.number2 = rand.nextInt(101);
		return rand.nextInt(3) + 1;
	}

	/**
	 * Hanterar addition
	 */
	public void addition() {
		consoleLine();
		this.result = number1 + number2;
		long startTime = getCurrentTime();
		System.out.println(number1 + " + " + number2);
		this.input = scan.nextLine();
		long endTime = getCurrentTime();
		totalTime += endTime - startTime;
		result();
		antalPlus[1]++;
		if (answerType) {
			antalPlus[0]++;
			trueTotalTime += endTime - startTime;
		}
	}

	/**
	 * Hanterar subtraktion
	 */
	public void subtraction() {
		consoleLine();
		this.result = number1 - number2;
		long startTime = getCurrentTime();
		System.out.println(number1 + " - " + number2);
		this.input = scan.nextLine();
		long endTime = getCurrentTime();
		totalTime += endTime - startTime;
		result();
		antalMinus[1]++;
		if (answerType) {
			antalMinus[0]++;
			trueTotalTime += endTime - startTime;
		}
	}

	/**
	 * Hanterar multiplikation
	 */
	public void multiplication() {
		consoleLine();
		this.number1 = number1 % 10;
		this.number2 = number2 % 10;
		this.result = number1 * number2;
		long startTime = getCurrentTime();
		System.out.println(number1 + " * " + number2);
		this.input = scan.nextLine();
		long endTime = getCurrentTime();
		totalTime += endTime - startTime;
		result();
		antalMult[1]++;
		if (answerType) {
			antalMult[0]++;
			trueTotalTime += endTime - startTime;
		}
	}

	/**
	 * Kollar om man skrev rätt svar, hanterar om användaren skrev in en sträng och
	 * inte ett tal
	 */
	public void result() {
		answerType = false;
		boolean errorCheck = false;// parameter för korrekt formaterat svar

		// parseInt kan kasta error NumberFormatExeption, fånga den och rätta till den
		try {
			this.numberInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			this.numberInput = 0;
			errorCheck = true;
			System.out.println("Oops, det du skrev var inte ett heltal. Det får du fel för!");
		}

		// svarade rätt
		if (numberInput == result && !errorCheck) {
			System.out.println("Rätt!");
			score++;
			answerType = true;
		}
		// svarade fel men på rätt format
		else if (numberInput != result && !errorCheck) {
			System.out.println("Fel!");
			System.out.println("Rätt svar var: " + result);
		}
	}

	/**
	 * Definerar antalet gånger spelaren vill spela
	 */
	public void definePlayAmount() {
		System.out.println("Ange hur många gånger du vill spela:");
		String input = scan.nextLine();
		// parseInt kan fånga NumberFormatExeption, fånga den
		try {
			spelomgangar = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			spelomgangar = 10;
			System.out.println("Du skrev inte in ett tal, så du får spela 10 gånger.");
		}
		if (spelomgangar == 0) {
			System.out.println("Du kan ju inte spela 0 gånger! Du får spela 10 gånger nu.");
			spelomgangar = 10;
		}
		if (spelomgangar < 0) {
			System.out.println("Du kan ju inte spela ett negativt antal gånger! Du får spela 10 gånger nu.");
			spelomgangar = 10;
		}
	}

	/*--------- Get-Satser ---------*/
	
	/**
	 * Hämtar antal spelomgångar
	 * 
	 * @return hur många gånger användaren ville spela.
	 */
	public int getSpelomgangar() {
		return spelomgangar;
	}

	/**
	 * Hämtar antal rätt svar
	 * 
	 * @return antal gånger spelaren svarade rätt
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Hämtar den genomsnittliga svarstiden
	 * 
	 * @return den genomsnittliga svarstiden i ms.
	 */
	public long getAverageTime() {
		long average = totalTime / spelomgangar;
		return average;
	}

	/**
	 * Hämtar genomsnittliga svarstiden för rätta svar
	 * 
	 * @return genomsnittliga tiden
	 */
	public long getTrueAverageTime() {
		if (getScore() != 0) {
			long average = trueTotalTime / getScore();
			return average;
		} else {
			return 0;
		}
	}

	/**
	 * Hämtar den nuvarande tiden
	 * 
	 * @return den nuvarande tiden
	 */
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}

	/*--------- Statistik ---------*/

	/**
	 * Visar grundläggande statistik
	 */
	public void showStatistics() {
		System.out.println("Du fick " + getScore() + " utav " + spelomgangar + " rätt.");// visar antal rätt
		if (getScore() / spelomgangar >= 0.9) {
			System.out.println("Grattis!");
		}
		System.out.println("Din genomsnittliga svarstid var " + getAverageTime() + "ms.");// visar genomsnittliga
																								// svarstiden
		if (getAverageTime() <= 500 && getScore() / spelomgangar >= 0.9) {
			System.out.println("Vänta lite, det luktar fusk här...");
		}
		System.out.println("Mera statistik:");
	}

	/**
	 * Visar djupare statistik
	 */
	public void showFullStatistics() {
		consoleLine();
		if (getScore() != 0) {
			System.out.println("Då du svarade rätt tog det dig i snitt " + getTrueAverageTime()
					+ "ms att få fram det rätta svaret.");
		}
		System.out.println("Du svarade rätt på " + antalMult[0] + " av " + antalMult[1] + " multiplikationer.");
		System.out.println("Du svarade rätt på " + antalPlus[0] + " av " + antalPlus[1] + " additioner.");
		System.out.println("Du svarade rätt på " + antalMinus[0] + " av " + antalMinus[1] + " subtraktioner.");
	}
}	