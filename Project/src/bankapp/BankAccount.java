package bankapp;

public class BankAccount {

	private static int nbrOfAccounts = 0;

	private Customer holder;
	private double balance;
	private int accountNr;

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och id
	 * 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0kr.
	 */
	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		this.balance = 0;
		this.accountNr = createAccountNr();
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas ett unikt
	 * kontonummer och innehåller inledningsvis 0kr.
	 */
	public BankAccount(Customer holder) {
		this.holder = holder;
		this.balance = 0;
		this.accountNr = createAccountNr();
	}

	/** Tar reda på kontots innehavare */
	public Customer getHolder() {
		return holder;
	}

	/** Tar reda på kontonummret som identifierar detta konto */
	public int getAccountNumber() {
		return accountNr;
	}

	/** Tar reda på kontots saldo */
	public double getAmount() {
		return balance;
	}

	/** Sätter in beloppet 'amount' på kontot */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Tar ut beloppet 'amount' från kontot. Om kontot saknar täckning blir saldot
	 * negativt.
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/** Returnerar en strängrepresentation av bankkontot */
	public String toString() {
		return "konto " + accountNr + "(" + holder.toString() + ")" + ": " + balance;
	}

	/* Hjälpmetod för accountNr */
	private int createAccountNr() {
		nbrOfAccounts++;
		return 1000 + nbrOfAccounts;
	}
	
}
