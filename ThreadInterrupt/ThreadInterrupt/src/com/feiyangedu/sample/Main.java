package com.feiyangedu.sample;

class HelloThread extends Thread {
	
	 boolean running = true;
	
	@Override
	public void run() {
		while (running) {
			System.out.println("Hello!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interrupted!");
				break;
			}
		}
		System.out.println("Thread end");
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		HelloThread t = new HelloThread();
		t.start();
		Thread.sleep(1000);
		t.running = false;
		System.out.println("Main end");
	}
}
