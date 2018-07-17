
public class Div {

	public static void main(String[] args) {
		int i = 99 / 9;
		System.out.println(i);
		// 整数运算的结果仍然是整数:
		int n = 100 / 9;
		System.out.println(n);
		int z = 100 / 0; // 报错
		// 后面的语句不会执行:
		System.out.println(z);
	}

}
