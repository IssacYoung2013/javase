package com.feiyangedu.sample;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringFormat {

	/**
	 * 将用户输入的不规范的字符串转换为无前后空格，大写字母开头的规范字符串，并滤掉空字符串和null，排序后返回。例如： 用户输入：
	 * 
	 * <code>{"HELLO", null, " ", "woRLd ", " java" }</code>
	 * 
	 * 返回：
	 * 
	 * <code>{"Hello", "Java", "World"}</code>
	 */
	public static String[] format(String[] input) {
		// TODO:
		String[] result =  Arrays.stream(input)
				.filter(n -> n != null)
				.map(String::trim)
				.filter(n-> !"".equals(n) &&! n.isEmpty())
				.map(n->{
					String temp = n.toLowerCase();
					System.out.println(temp);
					temp = temp.substring(0,1).toUpperCase().concat(temp.substring(1,temp.length()));
						
					return temp;
				}).sorted().toArray(String[]::new);
		return result;
	}
}
