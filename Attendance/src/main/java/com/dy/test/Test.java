package com.dy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		System.currentTimeMillis();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sf.format(new Date().getTime());
		System.out.println(date);
	}
}
