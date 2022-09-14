package com.lsx.codec.util;

import java.nio.charset.Charset;
import java.util.function.IntBinaryOperator;

/**
 * @author laishixiong
 * @time 2022/9/3 10:19
 */
public class ScaleUtil {

	public static void main(String[] args) {
		ScaleUtil scaleUtil = new ScaleUtil();
		scaleUtil.test();
	}

	public void test() {
		String s = "t1t2t3t4t67t";
		printStr(s.split("t"));
	}

	public void printStr(String[] strings) {
		for (String string : strings) {
			System.out.print(string + "-");
		}
		System.out.println("end");
	}

	//128E,高位在前
	public static String transform16To2(String str16) {
		byte[] bytes = transform16ToByte(str16);
		return showBytes2Bin(bytes);
	}

	//假设字符都是2的倍数 类似这种0xEE,不能带0x
	public static byte[] transform16ToByte(String str16) {
		str16 = str16.toUpperCase();
		byte[] charBytes = new byte[str16.length() / 2];
		char[] chars = str16.toCharArray();
		for (int i = 0; i < chars.length; i = i + 2) {
			//16进制字符转化成10进制
			int ret = charToInt(chars[i]) * 16 + charToInt(chars[i + 1]);
			System.out.println(ret);
			charBytes[i % 2] = (byte) ret;
		}
		return charBytes;
	}

	public static String showBytes2Bin(byte[] bytes) {

		StringBuilder stringBuilder = new StringBuilder(bytes.length * 9);
		for (byte b : bytes) {
			stringBuilder.append(Integer.toBinaryString(b & 0xFF)).append(" ");
		}
		return stringBuilder.toString();
	}

	public static void main222(String[] args) {
		//System.out.println(ScaleUtil.transform16ToByte("1E"));
		//System.out.println(ScaleUtil.transform16ToByte("FF"));
		//System.out.println(ScaleUtil.transform16ToByte("F0"));
		//System.out.println(ScaleUtil.transform16ToByte("0f"));
//		System.out.println(transform16To2("1E"));
//		System.out.println(transform16To2("FF"));
//		System.out.println(transform16To2("F0"));
//		System.out.println(transform16To2("0F"));
//		byte b = (byte) 255;
//		System.out.println(b);
//		System.out.println((char) b);
//		System.out.println((int) b);
//		System.out.println((int) (b&0xFF));
//		System.out.println(b&0xFF);
		//\u4f60\u597d\u554a
		byte[] bytes = transform16ToByte("4f60597d");

		char c = (char) bytes[0];
		Character cc = (char) bytes[0];
		//cc.
		String s1 = "a";
		byte[] gbks = s1.getBytes(Charset.forName("GBK"));
		System.out.println("长度：" + gbks.length);
		System.out.println(c);
		String retStr = new String(bytes, Charset.forName("gbk"));
		String retStr2 = new String("\u4f60\u597d\u554a");
		System.out.println(retStr2);
		System.out.println(retStr);

		//System.out.println((int)(c&0xFF));


	}

	//目前只能支持大写
	private static int charToInt(char c) {
		int i = 0;
		switch (c) {
			case 'F':
				i = 15;
				break;
			case 'E':
				i = 14;
				break;
			case 'D':
				i = 13;
				break;
			case 'C':
				i = 12;
				break;
			case 'B':
				i = 11;
				break;
			case 'A':
				i = 10;
				break;
			default:
				i = c - 48;

		}
		return i;
	}
}
