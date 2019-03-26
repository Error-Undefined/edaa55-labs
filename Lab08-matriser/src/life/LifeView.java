package life;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.EventObject;
import java.util.concurrent.LinkedBlockingQueue;

public class LifeView extends JFrame {
	private static final long serialVersionUID = 1L;

	private LifeBoard board;
	private int rows;
	private int cols;

	private int lastRow, lastCol;

	private LinkedBlockingQueue<EventObject> events = new LinkedBlockingQueue<EventObject>();

	private BoardView boardView = new BoardView();
	private JButton nextButton = new JButton("Next");
	private JButton quitButton = new JButton("Quit");
	private JLabel generationLabel = new JLabel("Generation: 1");

	/** Skapar en vy till spelplanen board. */
	public LifeView(LifeBoard board) {
		super("Game of Life");
		this.board = board;
		this.rows = board.getRows();
		this.cols = board.getCols();

		Box vbox = Box.createVerticalBox();
		boardView = new BoardView();
		boardView.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		vbox.add(boardView);

		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(nextButton);
		buttonBox.add(quitButton);
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(generationLabel);
		buttonBox.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

		vbox.add(buttonBox);
		add(vbox);

		boardView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				postEvent(e);
			}
		});
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				postEvent(e);
			}
		};
		nextButton.addActionListener(buttonListener);
		quitButton.addActionListener(buttonListener);

		getRootPane().setDefaultButton(nextButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setVisible(true);
	}

	/**
	 * Ritar upp de "fixa" delarna av spelplanen (rutnätet, generationsräknaren
	 * och knapparna).
	 */
	public void drawBoard() {
		update();
	}

	/**
	 * Ritar om de delar av ritfönstret som ändrats sedan föregående uppritning.
	 */
	public void update() {
		// För enkelhets skull ritas allt om varje gång
		generationLabel.setText("Generation: " + board.getGeneration());
		repaint();
	}

	/**
	 * Väntar tills användaren klickar med musen. Ger: 1: Klick i ruta på
	 * spelplanen. Index för rutan kan hämtas med getRow och getCol. 2: Klick i
	 * Next-rutan. 3: Klick i Quit-rutan.
	 */
	public int getCommand() {
		try {
			EventObject e = events.take();
			if (e.getSource() == boardView && e instanceof MouseEvent) {
				MouseEvent me = (MouseEvent) e;
				lastRow = boardView.getClickedRow(me.getY());
				lastCol = boardView.getClickedCol(me.getX());
				return 1;
			} else if (e.getSource() == nextButton) {
				return 2;
			} else if (e.getSource() == quitButton) {
				return 3;
			} else {
				throw new Error("unexpected event: " + e);
			}
		} catch (InterruptedException unexpected) {
			throw new Error("unexpected interruption");
		}
	}

	/** tag reda på radnummer för den klickade rutan */
	public int getRow() {
		return lastRow;
	}

	/** tag reda på kolonnummer för den klickade rutan */
	public int getCol() {
		return lastCol;
	}

	// hjälpmetod: köa Swing-events
	private void postEvent(EventObject e) {
		// undvik att blockera GUI-tråden
		if (!events.offer(e)) {
			throw new Error("Event unexpectedly lost: " + e);
		}
	}

	// -----------------------------------------------------------------------

	private static final Color cellColor = new Color(0, 100, 0);

	private class BoardView extends JComponent {
		private static final long serialVersionUID = 1L;

		public Dimension getPreferredSize() {
			return new Dimension(25 * cols + 1, 25 * rows + 1);
		}

		private double cellHeight() {
			return (getHeight() - getInsets().top - getInsets().bottom)
					/ (double) rows;
		}

		private double cellWidth() {
			return (getWidth() - getInsets().left - getInsets().right)
					/ (double) cols;
		}

		public int getClickedRow(int yClick) {
			return (int) ((yClick - getInsets().top) / cellHeight());
		}

		public int getClickedCol(int xClick) {
			return (int) ((xClick - getInsets().left) / cellWidth());
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int x = getInsets().left;
			int y = getInsets().top;

			g.setColor(Color.WHITE);
			g.fillRect(x, y, getWidth() - getInsets().left - getInsets().right,
					getHeight() - getInsets().top - getInsets().bottom);
			g.setColor(Color.LIGHT_GRAY);

			double cWidth = cellWidth();
			double cHeight = cellHeight();
			for (int r = 0; r <= rows; r++) {
				g.drawLine(x, y + (int) Math.round(r * cHeight),
						x + (int) Math.round(cWidth * cols),
						y + (int) Math.round(r * cHeight));
			}
			for (int c = 0; c <= cols; c++) {
				g.drawLine(x + (int) Math.round(c * cWidth), y,
						x + (int) Math.round(c * cWidth),
						y + (int) Math.round(cHeight * rows));
			}

			g.setColor(cellColor);
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (board.get(r, c)) {
						int x1 = x + (int) Math.round(c * cWidth);
						int x2 = x + (int) Math.round((c + 1) * cWidth) - 1;
						int y1 = y + (int) Math.round(r * cHeight);
						int y2 = y + (int) Math.round((r + 1) * cHeight) - 1;
						g.fillRect(x1 + 2, y1 + 2, x2 - x1 - 2, y2 - y1 - 2);
					}
				}
			}
		}
	}
}
