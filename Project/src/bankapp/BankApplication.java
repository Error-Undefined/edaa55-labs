package bankapp;

public class BankApplication {
	
	//Objekt för hjälpklass
	private static BankApplicationHelp helper;

	//Olika menyval
	public static void determineAction(int i) {
		if (i == 1) { // klar
			helper.getAccounts();
		} else if (i == 2) { // klar
			helper.searchForUser();
		} else if (i == 3) { // klar
			helper.insert();
		} else if (i == 4) { // klar
			helper.withdraw();
		} else if (i == 5) { // klar
			helper.transfer();
		} else if (i == 6) {// klar
			helper.newAccount();
		} else if (i == 7) { // klar
			helper.deleteAccount();
		} else if (i == 8) { // klar
			helper.getAllAccounts();
		} else if (i == 0) { // klar
			helper.exitNominal();
		} else { // klar
			return;
		}
	}

	
	public static void run() {
		//Main while-loop, static eftersom självaste applkationen ska bara finnas en gång
		while (true) {
			helper.printMenu();
			int input = helper.getMainInput();
			BankApplication.determineAction(input);
		}
	}

	public static void main(String[] args) {
		helper = new BankApplicationHelp();
		BankApplication.run();
		System.exit(1);
	}

}
