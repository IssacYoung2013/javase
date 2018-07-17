package com.feiyangedu.sample;

public enum Weekday {

	SUN("周日"), MON("周一"), TUE("周二"), WED("周三"), THU("周四"), FRI("周五"), SAT("周六");
	
	private String chinese;
	
	private Weekday(String chinses) {
		this.chinese = chinses;
	}

}
