package com.feiyangedu.sample;

import java.util.Arrays;

public class StreamReduceSample2 {

	public static void main(String[] args) throws Exception {
		String[] array = "Stream API supports functional-style operations".split(" ");
		String result = Arrays.stream(array).map(String::toLowerCase).reduce((acc, s) -> acc + " ~ " + s).get();
		System.out.println(result);
	}
}
