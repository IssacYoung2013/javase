package com.feiyangedu.sample;

import java.math.BigInteger;
import java.util.stream.Stream;

public class FibStream {

	public static Stream<BigInteger> create() {
		// FIXME: 返回Stream<BigInteger>
		return Stream.of(BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3),
				BigInteger.valueOf(5), BigInteger.valueOf(8));
	}

}
