package pair;

/** Ett par av heltal. */
public class Pair {
    private int a;
    private int b;
    
    /** Skapar ett nytt par av heltal. */
    public Pair(int a, int b) {
            this.a = a;
            this.b = b;
    }

    /** Hämtar parets första tal. */
    public int first() {
            return a;
    }

    /** Hämtar parets andra tal. */
    public int second() {
            return b;
    }
    
    /** Hämtar en sträng som beskriver paret, exempelvis "(5,3)". */
    public String toString() {
            return "(" + a + "," + b + ")";
    }
}
