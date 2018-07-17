package com.feiyangedu.sample;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Item {
	public String title;
	public String link;
	public String author;
	public String category;

	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	public ZonedDateTime pubDate;

	public String description;

}
