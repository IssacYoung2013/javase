
public class Continue {

	public static void main(String[] args) {
		int[] ns = { 31, 21, 22, 73, 79, 56, 7, 83, 19, 12, 53, 84, 68 };
		int sumOfOdds = 0;
		for (int n : ns) {
			if (n % 2 == 0) {
				System.out.println("skip " + n);
				continue;
			}
			sumOfOdds = sumOfOdds + n;
		}
		System.out.println(sumOfOdds);
	}
}
