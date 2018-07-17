package com.feiyangedu.sample;

public class Student implements Comparable<Student> {

	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String toString() {
		return "Student(" + name + ", " + score + ")";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.score < o.score ) {
			return 1;
		}
		return -1;
	}
	
	

}
