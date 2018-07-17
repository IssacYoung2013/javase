package com.feiyangedu.sample;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {

	static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.US);

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String s = p.getValueAsString();
		if (s != null) {
			try {
				return LocalDate.parse(s, FORMATTER);
			} catch (DateTimeException e) {
				// ignore
			}
		}
		return null;
	}

}
