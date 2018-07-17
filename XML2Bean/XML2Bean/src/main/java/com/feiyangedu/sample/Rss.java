package com.feiyangedu.sample;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "rss")
public class Rss {

	public Channel channel;

}
