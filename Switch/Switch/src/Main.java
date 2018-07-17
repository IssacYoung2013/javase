import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Select 1 ~ 4: ");
		int opt = scanner.nextInt();
		switch (opt) {
		case 1:
			System.out.println("Selected 1");
			break;
		case 2:
		case 3:
			System.out.println("Selected 2,3");
			break;
		case 4:
			System.out.println("Selected 4");
			break;
		default:
			System.out.println("Not selected.");
		}
		System.out.println("END");
	}
}
