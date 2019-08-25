package com.woniu.util.timedif;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class TimeDifference {
	TimeDifference(){
		
	}
	/***
	 * @comments 计算两个时间的时间差
	 * @param strTime1
	 * @param strTime2
	 */
	public String getTimeDifference(Date strTime1,Date strTime2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string1 = df.format(strTime1);
		String string2 = df.format(strTime2);
		String str = "0";
		   try{
			   Date now = df.parse(string1);
			   Date date=df.parse(string2);
			   long l=now.getTime()-date.getTime();       //获取时间差
			   long day=l/(24*60*60*1000);
			   long hour=(l/(60*60*1000)-day*24);
			   long min=((l/(60*1000))-day*24*60-hour*60);
			   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			   str = day+"天"+hour+"小时"+min+"分钟"+s+"秒";
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		return str;
	}
}
