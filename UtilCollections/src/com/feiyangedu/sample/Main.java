package com.feiyangedu.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> readOnlyList = Collections.unmodifiableList(list);
		System.out.println(readOnlyList);
		readOnlyList.add("X");
	}

}
