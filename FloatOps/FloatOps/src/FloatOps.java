
public class FloatOps {

	public static void main(String[] args) {
		double a = 0.1;
		double b = 1 - 9.0 / 10;
		System.out.println(a);
		System.out.println(b);
		// 注意没有自动提升的情况:
		double d1 = 1.2 + 24.0 / 5; // 6.0
		double d2 = 1.2 + 24 / 5; // 5.2
		System.out.println(d1);
		System.out.println(d2);
	}
}
