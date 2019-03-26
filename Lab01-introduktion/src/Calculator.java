import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		double sum = nbr1 + nbr2;
		double difference = nbr1 - nbr2;
		double product = nbr1*nbr2;
		double division = nbr1/nbr2;
		System.out.println("Summan av talen är " + sum);
		System.out.println("Skillnaden mellan talen är " + difference);
		System.out.println("Produkten av talen är " + product);
		System.out.println("Kvoten mellan talen är " + division);
	}
}
