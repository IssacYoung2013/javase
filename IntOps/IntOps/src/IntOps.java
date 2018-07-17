
public class IntOps {

	public static void main(String[] args) {
		int i = (100 + 200) * (99 - 88);
		System.out.println(i);
		int n = i + 9;
		System.out.println(n);
		int q = n / 100;
		System.out.println(q);
		n++; // n = n + 1
		System.out.println(n);
		n--; // n = n - 1
		System.out.println(n);
		n += 100; // n = n + 1
		n -= 100; // n = n - 1
		// 求余:
		int m = n % 100;
		System.out.println(m);
		// 注意运算结果溢出不会报错:
		int x = 2147483647 + 1;
		System.out.println(x); // -2147483648
		int y = 100000000 * 100000000;
		System.out.println(y);
	}

}
