/** En praktisk timer som kan användas för att fördröja exekveringen. */
public class Timer {
	
	/** Fördröj programmets exekvering med ett antal millisekunder. */
	public static void delay(long milliseconds) {
		if (milliseconds > 0) {
			try {
				Thread.sleep(milliseconds);
			} catch (InterruptedException ie) {
				throw new IllegalStateException("Unexpected interruption", ie);
			}
		}
	}
}