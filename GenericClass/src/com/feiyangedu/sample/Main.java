package com.feiyangedu.sample;

public class Main {

	public static void main(String[] args) {
		Pair<Integer> p = Pair.create(1, 2);
		Integer first = p.getFirst();
		Integer last = p.getLast();
		System.out.println(first);
		System.out.println(last);
		System.out.println(p.getClass() == Pair.class);
	}

}
