package com.feiyangedu.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonToBean {

	static final String JSON_URL = "https://api.douban.com/v2/book/search?q=";

	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json = search("java");
		SearchResult result = mapper.readValue(json, SearchResult.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
	}

	static String search(String q) {
		HttpURLConnection conn = null;
		StringBuilder sb = new StringBuilder(4096);
		try {
			URL url = new URL(JSON_URL + URLEncoder.encode(q, "UTF-8"));
			conn = (HttpURLConnection) url.openConnection();
			if (200 == conn.getResponseCode()) {
				try (BufferedReader reader = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
					char[] buffer = new char[1024];
					for (;;) {
						int n = reader.read(buffer);
						if (n == (-1)) {
							break;
						}
						sb.append(buffer, 0, n);
					}
				}
				return sb.toString();
			}
			throw new RuntimeException("Bad response code: " + conn.getResponseCode());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

}
