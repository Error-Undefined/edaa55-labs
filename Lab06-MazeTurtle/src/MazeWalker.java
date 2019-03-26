import se.lth.cs.pt.maze.Maze;

public class MazeWalker {

	private Turtle t;

	public MazeWalker(Turtle t) {
		this.t = t;
	}

	public void walk(Maze maze) {
		int x = maze.getXEntry();
		int y = maze.getYEntry();

		t.turnNorth();
		int angle = 90;
		
		t.penDown();
		t.jumpTo(x, y);
		while (!maze.atExit(x, y)) {
			if (!maze.wallAtLeft(angle, x, y)) {//Ingen vägg till vänster
				t.left(90);
				t.forward(1);
			} else if (maze.wallAtLeft(angle, x, y) && maze.wallInFront(angle, x, y)) {//Vägg till vänster & framför
				t.left(270);
			} else if (maze.wallAtLeft(angle, x, y) && !maze.wallInFront(angle, x, y)) {//Vägg bara till vänster
				t.forward(1);
			}
			angle=t.getDirection();
			x=t.getX();
			y=t.getY();			
		}
	}
}
