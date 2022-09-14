package com.lsx.codec;

import com.lsx.codec.util.ScaleUtil;

/**
 * @author laishixiong
 * @time 2022/9/3 10:18
 */
public class Main {
	public static void main(String[] args) {
		System.out.println(ScaleUtil.transform16To2("FF"));
		System.out.println(ScaleUtil.transform16To2("00"));
		System.out.println(ScaleUtil.transform16To2("F0"));
	}
	public void test1(){

	}
}
