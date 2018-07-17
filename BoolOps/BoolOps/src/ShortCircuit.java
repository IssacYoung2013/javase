
public class ShortCircuit {

	public static void main(String[] args) {
		int n = 0;
		boolean b = 5 / n > 0;
		boolean and = (5 < n) && (5 / n > 0);
		boolean or = (5 > n) || (5 / n > 0);
		System.out.println(and);
		System.out.println(or);
	}
}
