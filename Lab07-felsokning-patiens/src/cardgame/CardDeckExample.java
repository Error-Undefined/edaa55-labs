package cardgame;

import pair.Pair;
import pair.PairSet;

public class CardDeckExample {
	public static void main(String[] args) {
		
		// Skapa en kortlek och skriv ut alla kortens
		// värden i slumpmässig ordning
		
		PairSet cardDeck = new PairSet(4, 13);
		while (cardDeck.more()) {
			Pair p = cardDeck.pick();
			System.out.println(p);
		}
	}
}
