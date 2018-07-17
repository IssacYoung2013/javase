package com.feiyangedu.sample;

class HelloThread extends Thread {

	String name;

	public HelloThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello, " + name + "!");
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		Thread t1 = new HelloThread("Bob");
		Thread t2 = new HelloThread("Alice");
		t1.start();
		t2.start();
		for (int i = 0; i < 3; i++) {
			Thread.sleep(100);
			System.out.println("Main!");
		}
	}
}
