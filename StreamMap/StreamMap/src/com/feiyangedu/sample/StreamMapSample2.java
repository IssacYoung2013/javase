package com.feiyangedu.sample;

import java.util.Arrays;
import java.util.stream.Stream;

class Person {

	String name;
	char gender;

	public Person(String name, char gender) {
		this.name = name;
		this.gender = gender;
	}

	public String toString() {
		return "Persion(" + name + ", " + gender + ")";
	}
}

public class StreamMapSample2 {

	public static void main(String[] args) throws Exception {
		String[] inputs = { "Bob,M", "Alice,F", "Time,M", "Lily,F" };
		Stream<String> names = Arrays.stream(inputs);
		Stream<Person> persons = names.map((s) -> {
			int n = s.indexOf(',');
			String name = s.substring(0, n);
			char gender = s.charAt(n + 1);
			return new Person(name, gender);
		});
		persons.forEach(System.out::println);
	}
}
