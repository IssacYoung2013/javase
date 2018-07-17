package com.feiyangedu.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LambdaSortPractice {

	public static void main(String[] args) throws Exception {
		String[] array = new String[] { "Orange", "apple", "blackberry", "Pear" };
		ExecutorService executor = Executors.newCachedThreadPool();
		// 忽略大小写异步排序:
		Future<String[]> f = executor.submit(new Callable<String[]>() {
			public String[] call() {
				String[] copy = Arrays.copyOf(array, array.length);
				Arrays.sort(copy, new Comparator<String>() {
					public int compare(String s1, String s2) {
						return s1.toLowerCase().compareTo(s2.toLowerCase());
					}
				});
				return copy;
			}
		});
		System.out.println("Original: " + Arrays.toString(array));
		System.out.println("  Sorted: " + Arrays.toString(f.get()));
		executor.shutdown();
	}
}
