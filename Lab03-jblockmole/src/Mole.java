public class Mole {
	
	//Graphics med i ordning: bredd, höjd, blocksize och fullscreen
	private static Graphics g = new Graphics(192, 108, 10, true);

	public static void main(String[] args) {
		Mole m = new Mole();// mole objekt
		m.drawWorld();// ritar världen
		m.dig();// börjar gräva
	}

	/**
	 * Ritar upp världen
	 */
	public void drawWorld() {
		g.rectangle(0, 30, 192, 108, Colors.SOIL); // ritar marken
		g.rectangle(0, 29, 192, 1, Colors.GRASS); // ritar lite gräs
		g.rectangle(0, 0, 192, 29, Colors.SKY); // ritar lite himmel
	}

	/**
	 * Gräver omkring
	 */
	public void dig() {
		int x = g.getWidth() / 20;// x-start
		int y = g.getHeight() / 20;// y-start


		// main loop
		while (true) {
			
			/*
			 *Testar om man försöker gräva på fel ställe
			 */
			if (x == 192) {
				x--;
			}
			if (x < 0) {
				x++;
			}
			if (y <= 29) {
				if (y == 28) {
					g.block(x, y, Colors.SKY);
					y++;				
				}
			}
			if (y == 10) {
				y--;
			}
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			


			/*
			 * Testar de olika tangenterna
			 */
			
				//Går uppåt
			if (key == 'w') {
				y--;
				g.block(x, y, Colors.MOLE);
				g.block(x, y + 1, Colors.TUNNEL);
				
				//Går vänster
			} else if (key == 'a') {
				x--;
				g.block(x, y, Colors.MOLE);
				g.block(x + 1, y, Colors.TUNNEL);
				if (y == 29) {
					g.block(x+1, y, Colors.GRASS);
				}
				//Går neråt
			} else if (key == 's') {
				y++;
				g.block(x, y, Colors.MOLE);
				g.block(x, y - 1, Colors.TUNNEL);
				if (y == 30) {
					g.block(x, y-1, Colors.GRASS);
				}
				
				// Går höger
			} else if (key == 'd') {
				x++;
				g.block(x, y, Colors.MOLE);
				g.block(x - 1, y, Colors.TUNNEL);
				if (y == 29) {
					g.block(x-1, y, Colors.GRASS);
				}
			}
			
		}
	}
}
