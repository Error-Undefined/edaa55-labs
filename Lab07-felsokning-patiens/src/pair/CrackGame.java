package pair;

public class CrackGame {
	private static final int NBR_ITERATIONS = 500000;

	public static void main(String[] args) {
		double totalSucess = 0;

		for (int i = 0; i < NBR_ITERATIONS; i++) {
			boolean roundSucess = true;
			int iterate = 0;
			PairSet deck = new PairSet(4, 13);
			while (deck.more()) {
				if (iterate == 3) {
					iterate = 0;
				}
				Pair p = deck.pick();
				if (p.second() == iterate) {
					roundSucess = false;
				}
				iterate++;
			}
			if (roundSucess) {
				totalSucess++;
			}
		}

		double result = totalSucess / NBR_ITERATIONS;
		System.out.printf("%8f", result);
	}
}
