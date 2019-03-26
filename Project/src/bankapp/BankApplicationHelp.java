package bankapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplicationHelp {

	private static Scanner scan;
	private static Bank bank;

	/** Skapar en hjälpklass för applikationen */
	public BankApplicationHelp() {
		scan = new Scanner(System.in);
		bank = new Bank();
	}

	/** Hämtar huvudinput */
	public int getMainInput() {
		int input;
		try {
			input = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Felaktigt format på input");
			scan.nextLine();
			input = 0;
			BankApplication.run();
		}
		return input;
	}

	/* Metoder för hantering av inputs, 1-9 */

	/** Hämtar ett konto från id-nummer */
	public void getAccounts() {
		System.out.println("Id-nummer: ");
		long idNr = scan.nextLong();

		// Skapar en temporär lista
		ArrayList<BankAccount> tempList = bank.findAccountsForHolder(idNr);

		// Skriver ut alla konton
		if (tempList.size() > 0) {
			for (BankAccount acc : tempList) {
				System.out.println(acc);
			}
			// Fallet inga konton
		} else {
			System.out.println("Inga konton korresponderar till detta id-nummer.");
		}
	}

	/** Söker efter användare efter del av namn */
	public void searchForUser() {
		System.out.println("Namn: ");

		scan.nextLine();
		String name = scan.nextLine();

		// Skapar en temporär lista
		ArrayList<Customer> tempList = bank.findByPartOfName(name);

		// Ta bort dubletter; CustomerNr unikt för varje användare
		for (int i = 1; i < tempList.size(); i++) {
			if (tempList.get(i).getCustomerNr() == tempList.get(i - 1).getCustomerNr()) {
				tempList.remove(i);
			}
		}

		// Skriver ut hela temporära listan
		if (tempList.size() > 0) {
			for (Customer cus : tempList) {
				System.out.println(cus);
			}
			// Fallet inga konton
		} else {
			System.out.println("Inga användare hittades.");
		}
	}

	/** Sätter in pengar på ett konto */
	public void insert() {
		System.out.println("Till konto: ");
		int account = scan.nextInt();

		System.out.println("Belopp: ");
		double amount = scan.nextDouble();

		// Temporärt konto
		BankAccount tempAcc = bank.findByNumber(account);

		if (tempAcc == null) {
			System.out.println("Inget konto hittades.");
			return;
		}

		if (amount <= 0) {
			System.out.println("Felaktig mängd");
		} else {
			tempAcc.deposit(amount);
			System.out.println(tempAcc.toString());
		}
	}

	/** Tar bort pengar från ett konto om saldot inte faller under 0kr */
	public void withdraw() {
		System.out.println("Från konto: ");
		int account = scan.nextInt();

		System.out.println("Belopp: ");
		double amount = scan.nextDouble();

		BankAccount tempAcc = bank.findByNumber(account);
		if (tempAcc == null) {
			System.out.println("Inget konto hittades");
			return;
		}

		double saldo = tempAcc.getAmount();
		int nbr = tempAcc.getAccountNumber();

		if (amount > saldo && amount < 0) {
			System.out.println("Felaktig mängd");
		} else if (saldo < amount) {
			System.out.println("Uttaget misslyckades, konto " + nbr + " har endast " + saldo + " i saldo.");
		} else {
			tempAcc.withdraw(amount);
			System.out.println(tempAcc.toString());
		}
	}

	/** Överför pengar mellan två konton, om saldot inte faller under 0kr */
	public void transfer() {
		System.out.println("Från konto: ");
		int fromAccount = scan.nextInt();

		System.out.println("Till konto: ");
		int toAccount = scan.nextInt();

		System.out.println("Belopp: ");
		int amount = scan.nextInt();

		BankAccount tempAccAdd = bank.findByNumber(toAccount); // Kontot som får pengar
		BankAccount tempAccRemove = bank.findByNumber(fromAccount); // Kontot som blir av med pengar

		// Kolla att olika parametrar är rätt
		if (amount <= 0) {
			System.out.println("Felaktigt belopp.");
		} else if (tempAccAdd == null) {
			System.out.println("Konto till hittades inte.");
		} else if (tempAccRemove == null) {
			System.out.println("Konto från hittades inte.");
		} else if (tempAccRemove.getAmount() < amount) {
			System.out.println("Uttaget misslyckades, konto " + tempAccRemove.getAccountNumber() + " har endast "
					+ tempAccRemove.getAmount() + " i saldo.");
		}
		// Måste kolla två gånger, koden blir komplicerad annars
		else {
			tempAccAdd.deposit(amount);
			tempAccRemove.withdraw(amount);
			System.out.println(tempAccAdd);
			System.out.println(tempAccRemove);
		}
	}

	/** Lägger till ett konto i banken */
	public void newAccount() {
		scan.nextLine();

		System.out.println("namn: ");
		String name = scan.nextLine();

		System.out.println("id-nummer: ");
		long idNr = scan.nextLong();

		scan.nextLine();

		int i = bank.addAccount(name, idNr);
		System.out.println("Kontonummer: " + i);
	}

	/** Tar bort ett konto från banken */
	public void deleteAccount() {
		System.out.println("Konto: ");
		int input = scan.nextInt();

		boolean result = bank.removeAccount(input);

		if (!result) {
			System.out.println("Felaktigt kontonummer!");
		}
	}

	/** Hämtar en sorterad lista över alla konton och skriver ut de */
	public void getAllAccounts() {

		// Hämtar en sorterad lista
		ArrayList<BankAccount> sortedList = bank.getAllAccounts();
		if (sortedList.size() == 0) {
			System.out.println("Banken innehåller inga konton.");
		} else {
			for (BankAccount acc : sortedList) {
				System.out.println(acc);
			}
		}
	}

	public void exitNominal() {
		System.out.println("Hej då!");
		System.exit(0);
	}

	/** Skriver ut en meny för banken */
	public void printMenu() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("1. Hitta konto utifrån innehavare.");
		System.out.println("2. Sök kontoinnehavare efter namn, eller del av namn.");
		System.out.println("3. Sätt in pengar.");
		System.out.println("4. Ta ut pengar.");
		System.out.println("5. Överför pengar mellan två konton.");
		System.out.println("6. Skapa ett nytt konto.");
		System.out.println("7. Ta bort ett konto.");
		System.out.println("8. Skriv ut alla konton.");
		System.out.println("0. Avsluta programmet.");
		System.out.println("Val: ");
	}
}