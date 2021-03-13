package com.demo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 字符串处理类
 * 
 * @category 2013-05-06
 */
public class StringUtil {

	/**
	 * 从一个字符串中获得第一个连续串整数
	 * 
	 * @param str
	 * @return
	 */
	public static Integer getFirstIntegerFromStr(String str) {
		if (str == null || str.length() == 0) {
			return new Integer(0);
		}

		/* 获得第一个连续字符串数字 */
		char[] charArrays = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charArrays.length; i++) {
			if (Character.isDigit(charArrays[i])) {
				sb.append(charArrays[i]);
				if (i != charArrays.length
						&& !Character.isDigit(charArrays[i + 1])) {
					break;
				}
			}
		}

		/* str没有数字 */
		if (sb.toString().length() == 0) {
			return 0;
		}
		return new Integer(sb.toString());
	}

	/**
	 * 浮点型数字，保留后两位小数
	 * 
	 * @param d
	 * @return
	 */
	public static String double2String(double d) {
		DecimalFormat df = new DecimalFormat("0.00");
		String tem = df.format(d);
		return tem.toString();
	}

	/**
	 * 浮点型数字，保留后decimal位小数
	 * 
	 * @param d
	 * @return
	 */
	public static String doubleString(Double d, Integer decimal) {
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(decimal);
		String days = format.format(d);
		return days;
	}

	/**
	 * 对中文字符编码
	 * 
	 * @param src
	 * @return
	 */
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j)
					|| Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	/**
	 * 对编码后的中文解码
	 * 
	 * @param src
	 * @return
	 */
	public static String unescape(String src) {
		if (isBlank(src)) {
			return "";
		}

		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src
							.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src
							.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * 检查字符长度
	 * 
	 * @param str
	 * @param minLength
	 * @param maxLength
	 * @return
	 */
	public static boolean checkLength(String str, int minLength, int maxLength) {
		if (str != null) {
			int len = str.length();
			if (minLength == 0)
				return len <= maxLength;
			else if (maxLength == 0)
				return len >= minLength;
			else
				return (len >= minLength && len <= maxLength);
		}
		return false;
	}

	public static String decodeStringByUTF8(String str) {
		if (isBlank(str))
			return "";
		try {
			return URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}

	public static String encodeStringByUTF8(String str) {
		if (isBlank(str))
			return "";
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return "";
	}

	/**
	 * 转化日期(格式：yyyy-MM-dd hh-mm-ss)
	 * 
	 * @param d
	 * @return
	 */
	public static String getFormatDateStr(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(d);
	}

	/**
	 * 转化日期(自定义格式)
	 * 
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static String getFormatDateStr(Date d, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(d);
	}

	/**
	 * 获得唯一标识符
	 * 
	 * @return
	 */

	public static String getOnlyString() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 检查是否为null或空串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().equals(""));
	}

	/**
	 * 检查是否是整型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (isBlank(str))
			return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 检查是否是Long型
	 * 
	 * @return
	 */
	public static boolean isLong(String str) {
		if (isBlank(str))
			return false;
		try {
			Long.parseLong(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 检查是否是浮点型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		if (isBlank(str))
			return false;
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 检查是否是Integer型数组
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIntegers(String str[]) {
		try {
			for (int i = 0; i < str.length; i++)
				Integer.parseInt(str[i]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 检查是否是Long型数组
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isLongs(String str[]) {
		try {
			for (int i = 0; i < str.length; i++)
				Long.parseLong(str[i]);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 字符串转换为Boolean
	 * 
	 * @param str
	 * @return
	 */
	public static boolean[] stringsToBooleans(String str[]) {
		boolean array[] = new boolean[str.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Boolean.parseBoolean(str[i]);
		}
		return array;
	}

	public static boolean isTimestamp(String str) {
		try {
			java.sql.Date.valueOf(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 将首字母改为大写
	 * 
	 * @param word
	 * @return
	 */
	public static String changeFristLetterUpperCase(String word) {
		if (word == null || word.trim().length() < 0) {
			return "";
		}
		String firstLetter = word.substring(0, 1).toUpperCase();// 首字母大写
		word = firstLetter + word.substring(1, word.length());
		return word;
	}

	/**
	 * 去除最后一个字符
	 * 
	 * @param word
	 * @return
	 */
	public static String removeLastSign(String str) {
		if (!isBlank(str)) {
			return str.substring(0, str.length() - 1);
		}
		return "";
	}
	/**
	 * 20170417ymz
	 * 看当前字符串是否包含一个数字
	 */
	public static boolean isContain(String str1,String str2){
		boolean isContain = false;
		if(str1.contains(str2)||str1.contains(str2+",")||str1.contains(","+str2)||str1.contains(","+str2+",")){
			isContain = true;
		}
		return isContain;
	}
	/**
	 * 把String类型的日期转为Date类型
	 */
	public static Date getDate(String dateString,String simpleDateFormat){
		SimpleDateFormat format = new SimpleDateFormat(simpleDateFormat);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}

	/**
	 * 获取几天前的时间(yyyy-MM-dd)
	 * @param day 几天前
	 * @return 几天前的时间
	 */
	public static String getStatetime(int day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, - day);
		Date monday = c.getTime();
		String preMonday = sdf.format(monday);
		return preMonday;
	}
}
