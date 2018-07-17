package com.feiyangedu.time;

public class WorldClock {

	public static String getCurrentDateTime(String zoneId) {
		// FIXME:
		return "???";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getCurrentDateTime("Asia/Shanghai"));
		System.out.println(getCurrentDateTime("GMT+09:00"));
		System.out.println(getCurrentDateTime("Z"));
		System.out.println(getCurrentDateTime("America/New_York"));
	}

}
