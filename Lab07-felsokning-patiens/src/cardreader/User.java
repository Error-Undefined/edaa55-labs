package cardreader;

/** En användare i användartabellen. */
public class User {
	private int cardNbr;
	private String name;
	
	/** Skapar en ny användare med givet kortnummer och namn. */
	public User(int cardNbr, String name) {
		this.cardNbr = cardNbr;
		this.name = name;
	}
	
	/** Hämtar användarens kortnummer. */
	public int getCardNbr() {
		return cardNbr;
	}
	
	/** Hämtar användarens namn. */
	public String getName() {
		return name;
	}
	
	/** Hämtar en textbeskrivning av användaren, i formatet "12345 (Alfons Åberg)". */
	public String toString() {
		return cardNbr + " (" + name + ")";
	}
}
