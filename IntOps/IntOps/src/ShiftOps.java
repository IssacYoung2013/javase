
public class ShiftOps {

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = n1 << 10; // 5120
		int n3 = n2 >> 11; // 2
		int n4 = n1 << 29; // -1610612736
		int n5 = n4 >> 29; // -3
		int n6 = n4 >>> 29; // 5
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(n6);
	}

}
