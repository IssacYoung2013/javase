
public class Cond {

	public static void main(String[] args) {
		int n = 123;
		boolean positive = n >= 0;
		int abs = positive ? n : -n;
		System.out.println(abs);
	}
}
