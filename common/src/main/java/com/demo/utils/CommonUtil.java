package com.demo.utils;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	
	   static Calendar calendar = Calendar.getInstance();

	   public static void common(){
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(new Date());   
	   }
       
	   //返回今天是本月的第几周
	   public static int weekmonth(){
		    common();
		    return  calendar.get(Calendar.WEEK_OF_MONTH);
	   }
	   
	   //返回今天是本年的第几周
	   public static int weekyear(){
		    common();
		    return  calendar.get(Calendar.WEEK_OF_YEAR);
	   }	   
	   
	   //本月是今天的第几个月
	   public static int monthyear(){
		    common();
		    return  calendar.get(Calendar.MONTH)+1;
	   }
       
	   //返回今年的年份
	   public static int year(){
		    common();
		    return  calendar.get(Calendar.YEAR);
	   }
	   
	   public static int weekyearbycs(int i){
		   common();
		   int weekyear = calendar.get(Calendar.WEEK_OF_YEAR);
		   calendar.set(Calendar.WEEK_OF_YEAR, weekyear-i);
		   return calendar.get(Calendar.WEEK_OF_YEAR);
	   }
	   
	   public static int monthyearbycs(int i){
		   common();
		   calendar.set(Calendar.MONTH, i);
		   return calendar.get(Calendar.MONTH);
	   }
	 
	   public static int yearbycs(int i){
		   common();
		   int year = calendar.get(Calendar.YEAR);
		   calendar.set(Calendar.YEAR, year-i);
		   return calendar.get(Calendar.YEAR);
	   }	   
}
