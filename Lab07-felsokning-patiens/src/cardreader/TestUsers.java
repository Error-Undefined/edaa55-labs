package cardreader;

public class TestUsers {
	public static void main(String[] args) {	
		UserTable t = new UserTable();
		User u1=t.find(24073);
		User u2=t.find(24074);
		User u3=t.findByName("Jens Holmgren");
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		
		int ut= t.testFind();
		System.out.println(ut);

	}
}
