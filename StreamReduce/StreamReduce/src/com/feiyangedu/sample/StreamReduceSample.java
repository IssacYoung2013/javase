package com.feiyangedu.sample;

import java.util.stream.Stream;

public class StreamReduceSample {

	public static void main(String[] args) throws Exception {
		int r = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(100,(acc, x) -> acc * x);
		System.out.println(r);
	}
}
