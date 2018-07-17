
public class ToInt {

	public static void main(String[] args) {
		int n1 = (int) 12.3;
		int n2 = (int) 12.7;
		int n3 = (int) (12.7 + 0.5);
		int n4 = (int) 1.2e20; // 2147483647
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
	}
}
