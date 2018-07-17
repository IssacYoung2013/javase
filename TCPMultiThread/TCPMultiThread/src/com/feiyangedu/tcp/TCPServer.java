package com.feiyangedu.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(9090);
		System.out.println("TCP server ready.");
		for (;;) {
			Socket sock = ss.accept();
			System.out.println("Accept from " + sock.getRemoteSocketAddress());
			TimeHandler handler = new TimeHandler(sock);
			handler.start();
		}
	}
}

class TimeHandler extends Thread {

	Socket sock;

	TimeHandler(Socket sock) {
		this.sock = sock;
	}

	@Override
	public void run() {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))) {
			try (BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8))) {
				for (;;) {
					String cmd = reader.readLine();
					if ("q".equals(cmd)) {
						writer.write("bye!\n");
						writer.flush();
						break;
					} else if ("time".equals(cmd)) {
						writer.write(LocalDateTime.now().toString() + "\n");
						writer.flush();
					} else {
						writer.write("Sorry?\n");
						writer.flush();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
