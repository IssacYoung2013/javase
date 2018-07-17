package com.feiyangedu.sample;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String path = ".";
		if (args.length >= 1) {
			path = args[0];
		}
		File dir = new File(path).getCanonicalFile();
		// TODO: 按层级打印dir目录下所有子目录和文件
	}

}
