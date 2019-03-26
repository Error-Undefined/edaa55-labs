import se.lth.cs.pt.window.SimpleWindow;


public class RaceWindow extends SimpleWindow {
	public static final int X_START_POS = 100;
	public static final int X_END_POS = 700;
	public static final int Y_LINE_START = 100;
	public static final int Y_LINE_END = 280;
	
	public RaceWindow() {
		super(800, 400, "Race Window");
		setUp();
	}
	
	private void setUp(){
		super.moveTo(X_START_POS-10, Y_LINE_START+24);
		super.writeText("1");
		super.moveTo(X_START_POS-10, Y_LINE_START+44);
		super.writeText("2");
		super.moveTo(X_START_POS-10, Y_LINE_START+64);
		super.writeText("3");
		super.moveTo(X_START_POS-10, Y_LINE_START+84);
		super.writeText("4");
		super.moveTo(X_START_POS-10, Y_LINE_START+105);
		super.writeText("5");
		super.moveTo(X_START_POS-10, Y_LINE_START+124);
		super.writeText("6");
		super.moveTo(X_START_POS-10, Y_LINE_START+144);
		super.writeText("7");
		super.moveTo(X_START_POS-10, Y_LINE_START+164);
		super.writeText("8");
			
		super.moveTo(X_START_POS, Y_LINE_START);
		super.lineTo(X_START_POS, Y_LINE_END);
		
		super.moveTo(X_END_POS, Y_LINE_START);
		super.lineTo(X_END_POS, Y_LINE_END);
	}
	
	public static int getStartXPos(int startNbr){
		return X_START_POS;
	}

	public static int getStartYPos(int startNbr){
		return Y_LINE_START + startNbr*20;
	}
}

