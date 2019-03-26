package pair;

public class CardDeck {

	private static final int COLORS=4;
	private static final int RANKS=13;

	private int n;
	private PairSet deck;
	private Pair p;

	/**
	 * Skapar en kortlek med 52 kort, 13 valörer och 4 färger.
	 */
	public CardDeck() {
		this.deck = new PairSet(COLORS, RANKS);
		this.n=52;
	}

	/**
	 * Blandar leken, detta återställer den till 52 kort.
	 */
	public void shuffle() {
		deck = new PairSet(COLORS, RANKS);
		n=52;
	}

	/**
	 * Drar ett kort ur leken. Mängden minskar.
	 */
	public int[] pick() {
		p = deck.pick();
		int[] card = { p.first(), p.second() };
		n--;
		return card;
	}
	
	/**
	 * Returnerar antal kort kvar i leken
	 */
	public int getCards() {
		int cards=n;
		return cards;
	}
}
