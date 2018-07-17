package com.feiyangedu.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUpdate {

	static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
	static final String JDBC_USER = "root";
	static final String JDBC_PASSWORD = "123";

	public static void main(String[] args) throws Exception {
		List<Student> students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		Student std = students.get(0);
		std.classId = 2;
		std.name = "Alice";
		std.gender = "F";
		update(std);
		System.out.println("-- after update --");
		students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	static void update(Student std) throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = conn
					.prepareStatement("UPDATE students set class_id=?, name=?, gender=? WHERE id=?")) {
				ps.setObject(1, std.classId);
				ps.setObject(2, std.name);
				ps.setObject(3, std.gender);
				ps.setObject(4, std.id);
				int n = ps.executeUpdate();
				System.out.println(n + " updated.");
			}
		}
	}

	static List<Student> getAllStudents() throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students")) {
				try (ResultSet rs = ps.executeQuery()) {
					List<Student> list = new ArrayList<>();
					while (rs.next()) {
						// long id = rs.getLong(1); 注意:如果使用索引，index从1开始
						long id = rs.getLong("id");
						long classId = rs.getLong("class_id");
						String name = rs.getString("name");
						String gender = rs.getString("gender");
						Student std = new Student(id, classId, name, gender);
						list.add(std);
					}
					return list;
				}
			}
		}
	}

	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
}
