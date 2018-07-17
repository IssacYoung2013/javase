package com.feiyangedu.sample;

import java.util.Arrays;

public class StreamBasic {

	public static void main(String[] args) throws Exception {
		String[] array = "JDK Stream API supports functional-style operations".split(" ");
		// array -> stream:
		long n = Arrays.stream(array)
				// .filter((s) -> s.equals(s.toUpperCase()))
				.count();
		System.out.println("How many words? " + n);
	}
}
