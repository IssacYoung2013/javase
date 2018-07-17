package com.feiyangedu.sample;

public class Main {

	@SuppressWarnings({"unused","rawtypes"})
	public static void main(String[] args) throws Exception {
		Class cls = Main.class;
		Main.hello();
	}

	@Deprecated
	public static void hello() {
		
	}
	
	@Override
	public String toString() {
		return "Main";
	}
}
