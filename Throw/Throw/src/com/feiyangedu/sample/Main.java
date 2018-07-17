package com.feiyangedu.sample;

public class Main {

	public static void main(String[] args) {
		process1();
	}

	static void process1() {
		try {
			process2();
		} 
		catch(NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finnaly");
			throw new NullPointerException();
		}
	}

	static void process2() {
		process3();
	}

	static void process3() {
		Integer.parseInt(null);
	}
}
