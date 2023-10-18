package com.hung.tsm.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class MD5 {
	public static String getMd5String(String msg) {
		return Hashing.md5().hashString(msg, Charsets.UTF_8).toString();
	}
}
