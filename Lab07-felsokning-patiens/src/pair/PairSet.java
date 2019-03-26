package pair;

import java.util.Random;

public class PairSet {

	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();

	/**
	 * Skapar en mängd av alla talpar (a,b) sådana att 0 <= a < rows och 0 <= b <
	 * cols
	 */
	public PairSet(int rows, int cols) {
		this.n = rows * cols;
		this.pairs = new Pair[n];

		int a = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pairs[a] = new Pair(i, j);
				a++;
			}
		}

	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		return n > 0;
	}

	/**
	 * Hämtar ett slumpmässigt valt talpar ur mängden. Mängden blir ett element
	 * mindre. Om mängden är tom returneras null.
	 */
	public Pair pick() {
		if (more()) {
			int x = rand.nextInt(n);
			Pair p = pairs[x];
			pairs[x] = pairs[n-1];
			n--;
			return p;
		} else {
			return null;
		}
	}
}
