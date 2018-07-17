package com.feiyangedu.sample;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Book {

	public String id;
	public String title;
	public String subtitle;
	public List<String> author;

	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	public LocalDate pubdate;
	public String url;
	public String price;

}
