import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		Random rand = new Random();
		RaceTurtle.rand=rand;
		
		ArrayList<RaceTurtle> list1 = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> list2 = new ArrayList<RaceTurtle>();

		//Bestäm vilka turtles som deltar
		for (int i = 1; i <= 8; i++) {
			int decider = rand.nextInt(3);
			if (decider == 0) {
				DizzyTurtle t = new DizzyTurtle(w, i);
				list1.add(t);
			} else if (decider == 1) {
				AbsentMindedTurtle t = new AbsentMindedTurtle(w, i);
				list1.add(t);
			} else {
				MoleTurtle t = new MoleTurtle(w, i);
				list1.add(t);
			}
		}

		for (RaceTurtle t : list1) {
			System.out.println(t);
		}

		while (list1.size() > 5) {

			int breakPos = -1;

			for (int i = 0; i < list1.size(); i++) {
				RaceTurtle t = list1.get(i);
				if (t.getX() >= RaceWindow.X_END_POS) {
					breakPos = i;
					break;
				} else {
					t.raceStep();
				}
			}

			if (breakPos != -1) {
				list2.add(list1.remove(breakPos));
			}

			RaceWindow.delay(10);
		}

		System.out.println("-----------------------");

		System.out.println("På plats 1: " + list2.get(0).toString());
		System.out.println("På plats 2: " + list2.get(1).toString());
		System.out.println("På plats 3: " + list2.get(2).toString());
	}

}
