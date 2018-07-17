package com.feiyangedu.sample;

public class LambdaPractice {

	public static void main(String[] args) throws Exception {
		// TODO: 将Runnable改为lambda表达式:
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start new thread...");
			}
		});
		t.start();
		t.join();
	}
}
