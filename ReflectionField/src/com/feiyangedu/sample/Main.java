package com.feiyangedu.sample;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws Exception {
		Student s = new Student();
		Class cls = s.getClass();
		Field f = cls.getDeclaredField("address");
		f.setAccessible(true);
		f.set(s, "�Ϻ�");
		System.out.println(f.get(s));
		printFieldInfo(f);
		s.hello();
	}

	static void printFieldInfo(Field f) {
		System.out.println("field name: " + f.getName());
		System.out.println("field type: " + f.getType());
		System.out.println("field modifier: " + f.getModifiers());
		System.out.println("is public? " + Modifier.isPublic(f.getModifiers()));
		System.out.println("is protected? " + Modifier.isProtected(f.getModifiers()));
		System.out.println("is private? " + Modifier.isPrivate(f.getModifiers()));
		System.out.println("is static? " + Modifier.isStatic(f.getModifiers()));
		System.out.println("is final? " + Modifier.isFinal(f.getModifiers()));
	}

}
