package com.feiyangedu.sample;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMapSample {

	public static void main(String[] args) throws Exception {
		String[] array = "Stream API supports functional-style operations".split(" ");
		Stream<String> stream = Arrays.stream(array);
		stream.map(String::toUpperCase).forEach(System.out::println);
	}
}
