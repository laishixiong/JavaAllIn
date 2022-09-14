package com.lsx.codec.util;


import sun.security.util.ArrayUtil;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author laishixiong
 * @time 2022/9/8 14:46
 */
public class Unicode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Unicode unicode = new Unicode();
		unicode.test9();
	}

	private void test() {

		// 安💔  这个爱心是占了两个码元，汉字安是一个。idea里面会自动把两个码元的自动转换成UTF-16
		String s = "安\uD83D\uDC94";
		//程序运行的时候使用的是utf-16进行编码，一共三个码元
		char[] chars = s.toCharArray();
		System.out.println(chars); //安💔
		System.out.println(chars.length);//打印出来就是长度3

	}

	private void test2() throws UnsupportedEncodingException {
		String s = "安";
		//注意，如果这个参数不指定,默认使用UFT-8编码方式的字符集
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length);
		byte[] b2 = s.getBytes("UNICODE");
		System.out.println(b2.length);

	}

	private void test3() throws UnsupportedEncodingException {
		String s = "安";
		//注意，如果这个参数不指定,默认使用UFT-8编码方式的字符集
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length); //长度是3
		byte[] b2 = s.getBytes(Charset.forName("UTF-16"));
		System.out.println(b2.length); //长度是4
		b2 = s.getBytes(Charset.forName("UTF-16BE"));
		System.out.println(b2.length); //长度是2
		System.out.println(Integer.toHexString(b2[0] & 0xFF) + Integer.toHexString(b2[1] & 0xFF));

	}

	private void test4() throws UnsupportedEncodingException {
		String s = "安"; //unicode编码：	0x5B89 大端在前 ，码点值：23433 在65536范围呢直接把十六进制转成10进制就行
		//注意，如果这个参数不指定,默认使用UFT-8编码方式的字符集
		byte[] b2 = s.getBytes(Charset.forName("UTF-16BE"));
		System.out.println(b2.length); //长度是2
		System.out.println("\\u" + Integer.toHexString(b2[0] & 0xFF) + Integer.toHexString(b2[1] & 0xFF));
		System.out.println((b2[1] & 0xFF) + (b2[0] << 8 & 0xFFFF)); //23433 注意大端和小段
	}

	private void test5() {
		//码点转换成字符
		String s = "\\u5B89";//模拟运行的时候的时候程序从外界拿到了一个字符串 \u5B89 ，这个是码点编码之后的值
		System.out.println(s);//打印结果：\u5B89
		System.out.println(s.length()); //打印结果是6
		s = s.replaceAll("\\\\u", "");
		System.out.println(s); //打印结果5B89
		int codePoint = Integer.valueOf(s, 16);//23433
		char c = (char) codePoint;
		System.out.println(c); // 安
	}

	private void test6() {
		String s = "\\u5B89\\u5168\\u7B2C\\u4E00\\uD83D\\uDC94";//模拟运行的时候的时候程序从外界拿到了一个字符串：安全第一💔
		System.out.println(s);//打印结果：\u5B89\u5168\u7B2C\u4E00\uDC94
		System.out.println(s.length()); //打印结果是36
		String[] splits = s.split("\\\\u"); //该方法会解析出空字符串
		char[] rtc = new char[splits.length];
		for (int i = 0; i < splits.length; i++) {
			if (splits[i].length() > 0) {
				int codePoint = Integer.valueOf(splits[i], 16);
				rtc[i] = (char) codePoint;
			}
		}
		String newStr = new String(rtc);
		System.out.println(newStr); // 安全第一
	}

	private void test7() {
		String s = "\\uE5\\uAE\\u89"; //utf-8编码
		System.out.println(s.length()); //打印结果是12
		String[] splits = s.split("\\\\u"); //该方法会解析出空字符串
		byte[] bs = new byte[splits.length];
		for (int i = 0; i < splits.length; i++) {
			if (splits[i].length() > 0) {
				int codePoint = Integer.valueOf(splits[i], 16);
				bs[i] = (byte) codePoint;
			}
		}
		String s1 = new String(bs);
		System.out.println(s1); //安
	}

	private void test8() {
		String s = "\\uF0\\u9F\\u98\\u80";//utf-8编码
		System.out.println(s);//打印结果：
		System.out.println(s.length()); //打印结果是16
		String[] splits = s.split("\\\\u"); //该方法会解析出空字符串
		byte[] bs = new byte[splits.length];
		for (int i = 0; i < splits.length; i++) {
			if (splits[i].length() > 0) {
				int codePoint = Integer.valueOf(splits[i], 16);
				bs[i] = (byte) codePoint;
			}
		}
		String s1 = new String(bs);
		System.out.println(s1); // 😀
	}


	private void test9() {
		String s = "\\u00\\u01\\uF6\\u00"; //utf-32编码
		System.out.println(s);//打印结果：
		System.out.println(s.length()); //打印结果是16
		String[] splits = s.split("\\\\u"); //该方法会解析出空字符串

		byte[] bs = new byte[splits.length-1];
		for (int i = 1; i < splits.length; i++) {
			if (splits[i].length() > 0) {
				int codePoint = Integer.valueOf(splits[i], 16);
				bs[i-1] = (byte) codePoint;
			}
		}
		String s1 = new String(bs, Charset.forName("UTF-32"));//指定字符集为unicode-utf-32
		System.out.println(s1); // 😀
	}
}
