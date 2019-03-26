import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class AnimatedSquare {
	public static void main(String[] args) {

		int x1, x2, y1, y2, i = 0; // initiera koordinater för start (1) och slut (2) samt hjälpavariabel i
		
		SimpleWindow window = new SimpleWindow(1600, 900, "Jag är ett fönster"); // skapa fönster

		while (true) {

			// hämta startklick
			window.waitForMouseClick();
			x1 = window.getMouseX();
			y1 = window.getMouseY();

			// Rita första rutan
			Square square = new Square(x1, y1, 50);
			square.draw(window);

			// Hämta andra klick
			window.waitForMouseClick();
			x2 = window.getMouseX();
			y2 = window.getMouseY();

			// Radera första rutan
			square.erase(window);

			// Bestämma avstånd mellan rutor
			int xspace = 10;// avståndet mellan rutor i x defineras till 10
			int antalRutor = (int) Math.floor(Math.abs(x2 - x1) / xspace);// antal rutor som ska ritas

			if (antalRutor == 0) {// undvika division med 0 om vi klickar i samma punkt 2 gånger
				antalRutor = 1;
			}

			int yspace = (int) Math.floor(Math.abs((y2 - y1)) / antalRutor);// avståndet i y bestäms

			// Här börjar vi animera rutan
						if (x2 > x1) {// fallet vänster-höger
							int enumeratex = 1;// hålla reda på antal rutor + parametrar för ritning
							if (y2 > y1) {// fallet upp-ner
					

								// main ritningsloop
								while (enumeratex <= antalRutor) {
									square.move(xspace, yspace);
									square.draw(window);
									SimpleWindow.delay(10);
									enumeratex++;
								}

							} else {// fallet ner-upp
								// main ritningsloop
								while (enumeratex <= antalRutor) {
									square.move(xspace, -yspace);
									square.draw(window);
									SimpleWindow.delay(10);
									enumeratex++;
								}

							}

						} else {// fallet höger-vänster
							int enumeratex = -1;// hålla reda på antal rutor + parametrar för ritning
							antalRutor=-antalRutor;//Går negativt
							if (y2 > y1) {// fallet upp-ner
						

								// main ritningsloop
								while (enumeratex >= antalRutor) {
									square.move(-xspace, yspace);
									square.draw(window);
									SimpleWindow.delay(10);
									enumeratex--;
								}

							} else {// fallet ner-upp
								// main ritningsloop
								while (enumeratex >= antalRutor) {
									square.move(-xspace, -yspace);
									square.draw(window);
									SimpleWindow.delay(10);
									enumeratex--;
								}

							}

						}
					}
				}
			}