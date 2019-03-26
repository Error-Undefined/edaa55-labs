package cardgame;

import pair.Pair;
import pair.PairSet;

public class TestCardDeck {
 	/** Program för att testa metoderna i klassen PairSequence. Skapa en tänkt
 	    kortlek, dra korten och kontrollera att antalen stämmer. */
	public static void main(String[] args) {
		PairSet cardDeck = new PairSet(4, 13);
		int[] suitVect = new int[4];   // Antal spader, hjärter etc
		int[] rankVect = new int[13];  // Antal 1:or, 2:or etc

		System.out.println("Blandad kortlek:");
		while (cardDeck.more()) {
			Pair p = cardDeck.pick();
			suitVect[p.first()]++; 
			rankVect[p.second()]++;
			System.out.print(p + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.print("Antal kort i de olika färgerna: ");
		for (int i = 0; i < 4; i++) {
			System.out.print(suitVect[i] + " ");
		}
		System.out.println();
		
		System.out.print("Antal kort i de olika valörerna: ");
		for (int i = 0; i < 13; i++) {
			System.out.print(rankVect[i] + " ");
		}
		System.out.println();
	}
}
