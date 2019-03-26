package life;

public class LifeBoard {
	
	private int rows;
	private int cols;
	private int generation;
	private boolean[][] gameMatrix;

	/** Skapar en spelplan med rows rader och cols kolonner.
	    Spelplanen är från början tom, dvs alla rutorna är
	    tomma och generationsräknaren är 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows=rows;
		this.cols=cols;
		this.generation=1;
		this.gameMatrix=new boolean[rows][cols];
	}

	/** Undersöker om det finns en individ i rutan med index row,col, 
	    Om index row,col hamnar utanför spelplanen returneras false. */
	public boolean get(int row, int col) {
		if(row<0||row>rows-1||col<0||col>cols-1) {return false;}//Säkerhet

		boolean ret=gameMatrix[row][col];
		return ret;
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		gameMatrix[row][col]=val;
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		int row=rows;
		return row;
	}

 	/** Tar reda på antalet kolonner. */
	public int getCols() {
		int col=cols;
		return col;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		int gen=generation;
		return gen;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		generation++;
	}
}
