package life;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LifeController {
	public static void main(String[] args) {
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		Object[] message = { "Bredd:", field1, "Höjd:", field2 };

		JOptionPane.showConfirmDialog(null, message, "Ange dimensionerna", JOptionPane.OK_CANCEL_OPTION);
		int x1, x2;

		// fångar dålig input
		try {
			x1 = Integer.parseInt(field1.getText());
			x2 = Integer.parseInt(field2.getText());
		} catch (NumberFormatException e) {
			x1 = 20;
			x2 = 20;
		}

		LifeBoard board = new LifeBoard(x1, x2);
		LifeView view = new LifeView(board);
		Life life = new Life(board);

		while (true) {
			int x = view.getCommand();

			if (x == 1) {
				life.flip(view.getRow(), view.getCol());
				view.update();
			}
			if (x == 2) {
				life.newGeneration();
				view.update();
			}
			if (x == 3) {
				System.exit(0);
			}
		}
	}
}
