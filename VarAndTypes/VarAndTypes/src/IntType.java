
public class IntType {

	public static void main(String[] args) {
		byte b = 127; // -128 ~ +127
		short s = 32767; // -32768 ~ +32767
		int i = 2147483647; // -2147483648 ~ +2147483647
		long l = 9000000000000000000L; // -9223372036854775808 ~
										// +9223372036854775807
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);

		int i3 = 2_000_000_000;
		int i4 = 0xff0000; // 十六进制表示的十进制16711680
		int i5 = 0b1000000000; // 二进制表示的十进制512
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		// 输出十六进制表示的整型：
		System.out.println(Integer.toHexString(12345678)); // bc614e
		// 输出二进制表示的整型：
		System.out.println(Integer.toBinaryString(12345678)); // 101111000110000101001110
	}

}
