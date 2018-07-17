package com.feiyangedu.sample;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.Test;

public class FibStreamTest {

	@Test
	public void testFibStreamFirst10() {
		long[] result = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };
		Stream<BigInteger> stream = FibStream.create();
		assertArrayEquals(result, stream.limit(10).mapToLong(BigInteger::longValue).toArray());
	}

	@Test
	public void testFibStreamFirst10To20() {
		long[] result = { 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765 };
		Stream<BigInteger> stream = FibStream.create();
		assertArrayEquals(result, stream.skip(10).limit(10).mapToLong(BigInteger::longValue).toArray());
	}

}
