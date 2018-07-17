package com.feiyangedu.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcInsert {

	static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
	static final String JDBC_USER = "root";
	static final String JDBC_PASSWORD = "123";

	public static void main(String[] args) throws Exception {
		List<Student> students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		insertWithAutoGenerateId(new Student(2, "Tim", "M"));
		insertWithId(new Student(999, 2, "Bob", "M"));
		System.out.println("-- after insert --");
		students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	static void insertWithId(Student std) throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = conn
					.prepareStatement("INSERT INTO students (id, class_id, name, gender) VALUES (?, ?, ?, ?)")) {
				ps.setObject(1, std.id);
				ps.setObject(2, std.classId);
				ps.setObject(3, std.name);
				ps.setObject(4, std.gender);
				int n = ps.executeUpdate();
				System.out.println(n + " inserted.");
			}
		}
	}

	static void insertWithAutoGenerateId(Student std) throws SQLException {
		try (Connection conn = getConnection()) {
			try (PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO students (class_id, name, gender) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {
				ps.setObject(1, std.classId);
				ps.setObject(2, std.name);
				ps.setObject(3, std.gender);
				int n = ps.executeUpdate();
				System.out.println(n + " inserted.");
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						long id = rs.getLong(1);
						std.id = id;
					}
				}
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
