package pair;

public class TestDeck {
	public static void main(String[] args) {
		CardDeck cards = new CardDeck();
		int b = 52;

		while (b > 0) {
			int[] a = cards.pick();
			System.out.println(a[0] + " " + a[1]);
			b = cards.getCards();
			System.out.println(b);
		}
	}
}