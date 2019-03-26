package memory;


public class MemoryBoard {

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {

	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {

	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return 0;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return null;
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {

	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return false;
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return false;
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		return false;
	}	
}
