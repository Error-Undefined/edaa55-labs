import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MainMaze {
	public static void main(String[] args) {

		System.out.println("Vilken labyrint? (1 till 5)");
		
		Scanner scan = new Scanner(System.in);		
		int x=scan.nextInt();	
		scan.close();

		SimpleWindow w = new SimpleWindow(500, 500, "Maze");
		Turtle t = new Turtle(w, 200, 200);
		Maze m = new Maze(x);
		MazeWalker walker = new MazeWalker(t);
		
		w.open();		
		m.draw(w);
		walker.walk(m);
	}
}
