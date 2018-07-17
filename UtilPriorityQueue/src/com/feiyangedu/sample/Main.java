package com.feiyangedu.sample;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<Person> queue = new PriorityQueue<>();
		queue.offer(new Person("Ming", 12));
		queue.offer(new Person("Hong", 15));
		queue.offer(new Person("Jun", 17));
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
