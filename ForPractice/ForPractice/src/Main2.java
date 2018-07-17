
public class Main2 {

	public static void main(String[] args) {
		int[] ns = { 1, 4, 9, 16, 25 };
		// FIXME: 请输出1, 4, 9, 16, 25，即每个元素后面打印一个逗号和空格，但最后一个元素除外:
		for (int i = 0; i < ns.length; i++) {
			System.out.print(ns[i]);
			System.out.print(", ");
		}
	}

}
