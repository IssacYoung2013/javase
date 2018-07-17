
public class Main {

	/**
	 * 一元二次方程：a * x * x + b * x + c = 0
	 * 求解公式：
	 *       _____________
	 * -b ± √ b*b - 4*a*c
	 * -------------------
	 *        2*a
	 */
	public static void main(String[] args) {
		double a = 1.0;
		double b = 3.0;
		double c = -4.0;
		// 求平方根可用 Math.sqrt():
		// System.out.println(Math.sqrt(2)); ==> 1.414
		// FIXME:
		double r1 = 0;
		double r2 = 0;
		System.out.println(r1); // 1.0
		System.out.println(r2); // -4.0
	}

}
