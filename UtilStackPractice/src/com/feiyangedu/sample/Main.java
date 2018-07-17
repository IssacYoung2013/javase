package com.feiyangedu.sample;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = 12500;
		// 打印Integer.toHexString()的结果:
		System.out.println(Integer.toHexString(n));
		// 比较转换结果是否与JDK的一致:
		System.out.println(toHex(n));
	}

	static String toHex(int n) {
		// TODO:
		return "";
	}

	static char digitToChar(int m) {
		return DIGITS.charAt(m);
	}

	static final String DIGITS = "0123456789abcdef";

}
