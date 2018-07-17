package com.feiyangedu.sample;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Channel {
	public String title;
	public String description;
	public String language;
	public int ttl;
	public String category;

	@JacksonXmlProperty(localName = "item")
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Item> items = Collections.emptyList();

}
