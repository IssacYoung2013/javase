package com.feiyangedu.sample;

public class Main {

	public static void main(String[] args) throws Exception {
		ReadOnlyList<String> list = new ReadOnlyList<>("apple", "pear", "orange");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
