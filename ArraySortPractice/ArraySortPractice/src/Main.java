import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
		// 排序前:
		System.out.println(Arrays.toString(ns));
		// TODO: 修改为从大到小排序:
		for (int i = 0; i < ns.length; i++) {
			for (int j = i + 1; j < ns.length; j++) {
				if (ns[i] > ns[j]) {
					// 交换ns[i]和ns[j]:
					int tmp = ns[j];
					ns[j] = ns[i];
					ns[i] = tmp;
				}
			}
		}
		// 排序后:
		System.out.println(Arrays.toString(ns));
	}

}
