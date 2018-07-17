
public class Constant {

	public static void main(String[] args) {
		final double PI = 3.14;
		double r = 4.0;
		double length = PI * r * 2;
		double area = PI * r * r;
		System.out.println(length);
		System.out.println(area);
		// magic number:
		double salary = 12500.0;
		double pay = salary * (1 - 0.2);
		System.out.println(pay);
	}

}
