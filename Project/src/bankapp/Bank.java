package bankapp;

import java.util.ArrayList;

public class Bank {

	private ArrayList<BankAccount> accountList;

	/** Skapar en ny bank utan konton. */
	public Bank() {
		// Attribut för listan av alla konton
		this.accountList = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en användare i banken med
	 * de givna uppgifterna skapas inte en ny Customer, utan den befintliga används.
	 * Det nya kontonummret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		// Skapa ett temporärt konto
		BankAccount account = new BankAccount(holderName, idNr);
		// Kollar om det finns en användare med samma idNr i hela listan
		for (BankAccount a : accountList) {
			// Om idNr är det samma, använd andra konstruktorn
			if (a.getHolder().getIdNr() == idNr) {
				account = new BankAccount(a.getHolder());// Ersätter account-objektet
			}
		}
		// Lägger till kontot i listan
		accountList.add(account);

		return account.getAccountNumber();
	}

	/**
	 * Returnerar den kontoinnehavare som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {
		// Sök igenom alla konton
		for (BankAccount acc : accountList) {
			if (acc.getHolder().getIdNr() == idNr) {
				return acc.getHolder();
			}
		}
		return null;
	}

	/**
	 * Tar bort kontot med nummer 'number' från banken. Returnerar true om kontot
	 * fanns och togs bort utan fel, annars false
	 */
	public boolean removeAccount(int number) {
		// Sök igenom alla konton
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getAccountNumber() == number) {
				accountList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	public ArrayList<BankAccount> getAllAccounts() {

		// Skapa en tom lista som till slut är sorterad
		ArrayList<BankAccount> sortedList = new ArrayList<BankAccount>();

		/*
		 * Metod för sortering: Ta det element som är längst till höger i arrayList.
		 * Jämför med alla andra element kvar i listan Plocka ut det minsta och lägg
		 * till det i sortedList Kör medans det finns element i accountList
		 */

		for (int i = accountList.size() - 1; i >= 0; i--) {
			// Temporär variabel som håller reda på index av första konto i bokstavsordning
			int temp = i;
			String lowest = accountList.get(i).getHolder().getName();
			for (int k = 0; k < accountList.size() - 1; k++) {
				String current = accountList.get(k).getHolder().getName();

				if (current.toLowerCase().compareTo(lowest.toLowerCase()) < 0) {
					temp = k;
				}
			}
			// Ta bort kontot ur accountList och lägg till det i sortedList, vi får alltid
			// fram ett minsta värde
			sortedList.add(accountList.remove(temp));
		}
		accountList = sortedList;
		return sortedList;
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer 'accountNumber'.
	 * Returnerar null om inget konto hittades.
	 */
	public BankAccount findByNumber(int accountNumber) {
		// Linjärsökning, konton aldrig sorterade efter nbr
		for (BankAccount acc : accountList) {
			if (acc.getAccountNumber() == accountNumber) {
				return acc;
			}
		}
		return null;
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer 'idNr'.
	 * Kontorna returneras i en lista. Kunderna har unika id-nummer.
	 */
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		// Skapa en temporär lista som returneras
		ArrayList<BankAccount> tempList = new ArrayList<BankAccount>();

		// Sök igenom hela accountList
		for (BankAccount acc : accountList) {
			if (acc.getHolder().getIdNr() == idNr) {
				tempList.add(acc);
			}
		}

		return tempList;
	}

	/**
	 * Söker upp kunder från en sökning på namn eller delar av namn. Alla personer
	 * vars namn innehåller strängen 'namePart' inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i listan.
	 * Sökningen är "case insensitive."
	 */

	public ArrayList<Customer> findByPartOfName(String namePart) {

		// Temporär lista som returneras
		ArrayList<Customer> tempList = new ArrayList<Customer>();

		// Sök igenom hela accountList
		for (int i = 0; i <= accountList.size() - 1; i++) {

			Customer holder = accountList.get(i).getHolder();// Customer som undersöks
			String currentName = holder.getName();// Dess namn

			if (currentName.toLowerCase().contains(namePart.toLowerCase())) {
				tempList.add(holder);
			}
		}

		return tempList;
	}
}
