import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();

		ArrayList<RaceTurtle> list1 = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> list2 = new ArrayList<RaceTurtle>();

		for (int i = 1; i <= 8; i++) {
			RaceTurtle t = new RaceTurtle(w, i);
			list1.add(t);
		}

		while (list1.size() != 0) {
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

		System.out.println("På plats 1: " + list2.get(0).toString());
		System.out.println("På plats 2: " + list2.get(1).toString());
		System.out.println("På plats 3: " + list2.get(2).toString());
	}

}
