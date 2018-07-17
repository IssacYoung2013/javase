package com.feiyangedu.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLToBean {

	static final String XML_URL = "http://rss.sina.com.cn/tech/internet/home28.xml";

	public static void main(String[] args) throws Exception {
		Rss rss = null;
		JacksonXmlModule module = new JacksonXmlModule();
		module.addDeserializer(String.class, new JsonDeserializer<String>() {
			@Override
			public String deserialize(JsonParser p, DeserializationContext ctxt)
					throws IOException, JsonProcessingException {
				String s = p.getValueAsString();
				return s == null ? null : s.trim();
			}
		});
		XmlMapper mapper = new XmlMapper(module);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String xml = get(XML_URL);
		rss = mapper.readValue(xml, Rss.class);
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rss));
	}

	static String get(String theUrl) {
		HttpURLConnection conn = null;
		StringBuilder sb = new StringBuilder(4096);
		try {
			URL url = new URL(theUrl);
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
