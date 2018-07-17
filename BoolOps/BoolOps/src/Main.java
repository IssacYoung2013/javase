
public class Main {

	public static void main(String[] args) {
		int age = 8;
		boolean isGreaterThan6 = age > 6;
		boolean isLessThan12 = age < 12;
		boolean isPrimaryStd = isGreaterThan6 && isLessThan12;
		boolean isNotPrimaryStd = !isGreaterThan6 || !isLessThan12;
		System.out.println(isPrimaryStd);
		System.out.println(isNotPrimaryStd);
	}
}
