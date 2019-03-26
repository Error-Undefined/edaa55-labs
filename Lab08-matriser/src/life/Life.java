package life;

public class Life {

	private LifeBoard board;

	public Life(LifeBoard board) {
		this.board = board;
	}

	public void newGeneration() {
		int cols = board.getCols();
		int rows = board.getRows();
		boolean[][] newBoard = new boolean[rows][cols];

		for (int i = 0; i <= rows-1; i++) {
			for (int j = 0; j <= cols-1; j++) {
				int neighbors = neighborCheck(i, j);
				if(board.get(i, j)) {
					if(neighbors>=4||neighbors<=1) {
						newBoard[i][j]=false;
					}
					else {
						newBoard[i][j]=true;
					}
				}
				else {
					if(neighbors==3) {
						newBoard[i][j]=true;
					}
				}
					
			}
		}

		for(int i=0;i<=rows-1;i++) {
			for(int j=0;j<=cols-1;j++) {
				board.put(i, j, newBoard[i][j]);
			}
		}
		board.increaseGeneration();
	}

	public void flip(int row, int col) {
		if (board.get(row, col)) {
			board.put(row, col, false);
		} else {
			board.put(row, col, true);
		}
	}

	public int neighborCheck(int row, int col) {
		int amount=0;
	
		if(board.get(row-1, col-1)) {
			amount++;
		}
		if(board.get(row-1, col)) {
			amount++;
		}
		if(board.get(row-1, col+1)) {
			amount++;
		}
		if(board.get(row, col-1)) {
			amount++;
		}
		if(board.get(row, col+1)) {
			amount++;
		}
		if(board.get(row+1, col-1)) {
			amount++;
		}
		if(board.get(row+1, col)) {
			amount++;
		}
		if(board.get(row+1, col+1)) {
			amount++;
		}


		return amount;
	}

}
