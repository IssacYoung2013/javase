package com.feiyangedu.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTx {

	static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
	static final String JDBC_USER = "root";
	static final String JDBC_PASSWORD = "123";

	public static void main(String[] args) throws Exception {
		List<Student> students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		// commmit tx:
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn.setAutoCommit(false);
			updateName(conn, students.get(0).id, "Bob");
			updateName(conn, students.get(1).id, "Alice");
			conn.commit();
			System.out.println("commit ok.");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		}
		System.out.println("-- after commit tx --");
		students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		// rollback tx:
		conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			updateName(conn, students.get(0).id, "小明");
			updateName(conn, students.get(1).id, "小红");
			throw new RuntimeException("will rollback");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		}
		System.out.println("-- after rollback tx --");
		students = getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	static void updateName(Connection conn, long id, String name) throws SQLException {
		try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
			ps.setObject(1, name);
			ps.setObject(2, id);
			ps.executeUpdate();
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
