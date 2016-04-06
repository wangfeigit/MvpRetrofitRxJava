package com.example.wangfei.mvpretrofitrxjava.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;


public class StringUtil {

	/**转化十六进制编码为字符串   */
	 public static String toStringHex(String s) {  
	    byte[] baKeyword = new byte[s.length() / 2];  
	    for (int i = 0; i < baKeyword.length; i++) {  
	     try {  
	      baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(  
	        i * 2, i * 2 + 2), 16));  
	     } catch (Exception e) {  
	      e.printStackTrace();  
	     }  
	    }  
	    try {  
	     s = new String(baKeyword, "utf-8");// UTF-16le:Not   
	    } catch (Exception e1) {  
	     e1.printStackTrace();  
	    }  
	    return s;  
	 }  
	 
	 /**
		 * 十六进制字符串转换成bytes
		 */
		private static byte uniteBytes(String src0, String src1) {
			byte b0 = Byte.decode("0x" + src0).byteValue();
			b0 = (byte) (b0 << 4);
			byte b1 = Byte.decode("0x" + src1).byteValue();
			byte ret = (byte) (b0 | b1);
			return ret;
		}
		
		public static  byte[] hexStr2Bytes(String src) {
			int m = 0, n = 0;
			int l = src.length() / 2;
			byte[] ret = new byte[l];
			for (int i = 0; i < l; i++) {
				m = i * 2 + 1;
				n = m + 1;
				ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
			}
			return ret;
		}
		
	private byte[] getBytes (char[] chars) {
		   Charset cs = Charset.forName ("UTF-8");
		   CharBuffer cb = CharBuffer.allocate (chars.length);
		   cb.put (chars);
		   cb.flip ();
		   ByteBuffer bb = cs.encode (cb);
		   return bb.array();
	}
	
	
	public static byte[] strToBcd(String asc,Integer mode) {
		 int len = asc.length();
		 int mod = len % 2;
		 if (mod != 0) {
		 if (mode==1) {
		 asc =  asc+"0";
		 }else{
		 asc =  "0"+asc;
		 }
		 len = asc.length();
		 }
		 byte abt[] = new byte[len];
		 if (len >= 2) {
		 len = len / 2;
		 }
		 byte bbt[] = new byte[len];
		 abt = asc.getBytes();
		 int j, k;
		 for (int p = 0; p < asc.length() / 2; p++) {
		 if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
		 j = abt[2 * p] - '0';
		 } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
		 j = abt[2 * p] - 'a' + 0x0a;
		 } else {
		 j = abt[2 * p] - 'A' + 0x0a;
		 }

		 if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
		 k = abt[2 * p + 1] - '0';
		 } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
		 k = abt[2 * p + 1] - 'a' + 0x0a;
		 } else {
		 k = abt[2 * p + 1] - 'A' + 0x0a;
		 }

		 int a = (j << 4) + k;
		 byte b = (byte) a;
		 bbt[p] = b;
		 }
		 return bbt;
	}
	
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}
	
	byte CapkList[] = { (byte) 0xA0, 0x00, 0x00, 0x03, 0x33, 0x01, 0x01, 0x01,
			(byte) 0x80, (byte) 0xBB, (byte) 0xE9, 0x06, 0x6D, 0x25, 0x17,
			0x51, 0x1D, 0x23, (byte) 0x9C, 0x7B, (byte) 0xFA, 0x77,
			(byte) 0x88, 0x41, 0x44, (byte) 0xAE, 0x20, (byte) 0xC7, 0x37,
			0x2F, 0x51, 0x51, 0x47, (byte) 0xE8, (byte) 0xCE, 0x65, 0x37,
			(byte) 0xC5, 0x4C, 0x0A, 0x6A, 0x4D, 0x45, (byte) 0xF8,
			(byte) 0xCA, 0x4D, 0x29, 0x08, 0x70, (byte) 0xCD, (byte) 0xA5,
			(byte) 0x9F, 0x13, 0x44, (byte) 0xEF, 0x71, (byte) 0xD1, 0x7D,
			0x3F, 0x35, (byte) 0xD9, 0x2F, 0x3F, 0x06, 0x77, (byte) 0x8D, 0x0D,
			0x51, 0x1E, (byte) 0xC2, (byte) 0xA7, (byte) 0xDC, 0x4F,
			(byte) 0xFE, (byte) 0xAD, (byte) 0xF4, (byte) 0xFB, 0x12, 0x53,
			(byte) 0xCE, 0x37, (byte) 0xA7, (byte) 0xB2, (byte) 0xB5,
			(byte) 0xA3, 0x74, 0x12, 0x27, (byte) 0xBE, (byte) 0xF7, 0x25,
			0x24, (byte) 0xDA, 0x7A, 0x2B, 0x7B, 0x1C, (byte) 0xB4, 0x26,
			(byte) 0xBE, (byte) 0xE2, 0x7B, (byte) 0xC5, 0x13, (byte) 0xB0,
			(byte) 0xCB, 0x11, (byte) 0xAB, (byte) 0x99, (byte) 0xBC, 0x1B,
			(byte) 0xC6, 0x1D, (byte) 0xF5, (byte) 0xAC, 0x6C, (byte) 0xC4,
			(byte) 0xD8, 0x31, (byte) 0xD0, (byte) 0x84, (byte) 0x87,
			(byte) 0x88, (byte) 0xCD, 0x74, (byte) 0xF6, (byte) 0xD5, 0x43,
			(byte) 0xAD, 0x37, (byte) 0xC5, (byte) 0xA2, (byte) 0xB4,
			(byte) 0xC5, (byte) 0xD5, (byte) 0xA9, 0x3B, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x03, 0x00, 0x00,
			0x09, 0x12, 0x31, (byte) 0xE8, (byte) 0x81, (byte) 0xE3,
			(byte) 0x90, 0x67, 0x5D, 0x44, (byte) 0xC2, (byte) 0xDD,
			(byte) 0x81, 0x23, 0x4D, (byte) 0xCE, 0x29, (byte) 0xC3,
			(byte) 0xF5, (byte) 0xAB, 0x22, (byte) 0x97, (byte) 0xA0 };

	byte AidList[] = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, (byte) 0xA0, 0x00, 0x00, 0x03, 0x33, 0x01, 0x01, 0x01,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x08, 0x00,
			0x00, 0x63, 0x63, 0x00, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x10, 0x00, 0x00, 0x00, 0x00, (byte) 0xD8,
			0x40, 0x04, (byte) 0xF8, 0x00, 0x00, (byte) 0xD8, 0x40, 0x00,
			(byte) 0xA8, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x03, (byte) 0x9F, 0x37, 0x04, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x20, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01,
			(byte) 0xA0, (byte) 0x86, 0x01, 0x00, 0x00, (byte) 0xA0,
			(byte) 0x86, 0x01, 0x00, (byte) 0xA0, (byte) 0x86, 0x01, 0x00,
			(byte) 0xA0, (byte) 0x86, 0x01, 0x00, 0x0a };
}
