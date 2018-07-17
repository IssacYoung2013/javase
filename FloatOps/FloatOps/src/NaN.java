
public class NaN {

	public static void main(String[] args) {
		double d1 = 0.0 / 0; // NaN
		double d2 = 1.0 / 0; // Infinity
		double d3 = -1.0 / 0; // -Infinity
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}
