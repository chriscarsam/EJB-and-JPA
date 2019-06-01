package com.sambcode.app.appwebschedule;

import org.apache.commons.codec.digest.DigestUtils;

public class MyHelper {
	public String encrypt(String text) {
		String key = "dfuifdgfd5441h1c";

		String textEncrypted = DigestUtils.sha512Hex(text + key);
		return textEncrypted;
	}
}
