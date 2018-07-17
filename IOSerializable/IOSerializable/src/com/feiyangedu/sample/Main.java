package com.feiyangedu.sample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String dataFile = "saved.data";
		try (ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			// 依次写入 int, String, Person:
			output.writeInt(999);
			output.writeUTF("Hello, world!");
			output.writeObject(new Person("Xiao Ming"));
		}
		System.out.println("Read...");
		try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			// 依次读入 int, String, Person:
			System.out.println(input.readInt());
			System.out.println(input.readUTF());
			Person p = (Person) input.readObject();
			System.out.println(p);
		}
	}

}
