package com.feiyangedu.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Ming", 12), new Person("Hong", 15), new Person("Jun", 18));
		Map<Person, String> map = new HashMap<>();
		for (Person p : list) {
			map.put(p, p.getName());
		}
		System.out.println(map.get(new Person("Jun", 18)));
	}

}
