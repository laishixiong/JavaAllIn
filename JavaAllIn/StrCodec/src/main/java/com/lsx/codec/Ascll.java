package com.lsx.codec;

/**
 * @author laishixiong
 * @time 2022/9/8 14:42
 */
public class Ascll {
	public static void main(String[] args) {
		Ascll ascll = new Ascll();
		ascll.test();
	}

	private void test() {
		char c = 65;
		System.out.println(c);//打印A
		byte b = 65;
		System.out.println(c);//打印A
		byte b2= (byte) 128;
		System.out.println(b2);//表示不了，直接解析成了数字-128
	}
}
