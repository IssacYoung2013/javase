package com.feiyangedu.sample;

import java.util.function.Supplier;
import java.util.stream.Stream;

class NaturalSupplier implements Supplier<Long> {

	long x = 0;

	public Long get() {
		x++;
		return x;
	}

}

public class StreamFilterSample {

	public static void main(String[] args) throws Exception {
		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		Stream<Long> odd = natural.filter((n) -> n % 5 == 0);
		odd.limit(20).forEach(System.out::println);
	}
}
