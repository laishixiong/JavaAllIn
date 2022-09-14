package com.main;

import sun.misc.HexDumpEncoder;

import java.io.UnsupportedEncodingException;

/**
 * @author laishixiong
 * @time 2022/8/5 15:32
 */
public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String source = new String("0061");
		//String source = new String("00614E2D6587");
		//String source = new String("00614E2D6587");
		HexDumpEncoder hexDumpEncoder = new HexDumpEncoder();
		int i = Integer.parseInt(source, 16);
		byte b = (byte) i;
		byte[] bs = source.getBytes();
		//String newStr = new String(bs,"");
		//System.out.println(newStr);
	}
}
