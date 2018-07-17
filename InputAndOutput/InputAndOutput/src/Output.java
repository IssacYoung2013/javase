
public class Output {

	public static void main(String[] args) {
		double d = 3.1415926;
		System.out.println(d);
		System.out.printf("PI = %.2f\n", d);
		System.out.printf("PI = %7.2f\n", d);
		// 格式化小数:
		double f = 0.123456;
		System.out.printf("%f\n", f); // 0.123456
		System.out.printf("%e\n", f); // 1.234560e-01
		System.out.printf("%.2f\n", f); // 0.12
		System.out.printf("%6.2f\n", f); // <space><space>0.12
		System.out.printf("%+.2f\n", f); // +0.12
		// 调整参数顺序:
		System.out.printf("%s %s %s\n", "A", "B", "C");
		System.out.printf("%2$s %1$s %1$s %3$s\n", "A", "B", "C");
		// 参数不够，报错:
		System.out.printf("%s %s %s\n", "A", "B");
	}

}
