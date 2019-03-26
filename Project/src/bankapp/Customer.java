package bankapp;

public class Customer {
	
	private static int nbrOfCustomers = 0;
	
	private String name;
	private long idNr;
	private int customerNr;

	/**
	 * Skapar en kund med namnet 'name' och id-nummer 'idNr'. Kunden tilldelas också
	 * ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.customerNr = createCustomerNr();
	}

	/** Tar reda på kundens namn. */
	public String getName() {
		return name;
	}

	/** Tar reda på kundens personnummer. */
	public long getIdNr() {
		return idNr;
	}

	/** Tar reda på kundens banknummer. */
	public int getCustomerNr() {
		return customerNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return name + ", id " + idNr + ", kundnr " + customerNr;
	}

	/* Hjälpmetod för customerNr */
	private int createCustomerNr() {
		nbrOfCustomers++;
		return 100 + nbrOfCustomers;
	}
}
