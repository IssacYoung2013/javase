package com.feiyangedu.sample;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountInputStream extends FilterInputStream {
	
	int count = 0;
	
	public CountInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		int n = super.read(b,off,len);
		count += 1;
		return n;
	}
	
	
	
}
