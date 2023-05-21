package com.gurudemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * DateUtils class contains two methods
 * getTimeStamp() returns the String value of date and time in yyyy.MM.dd.HH.mm.ss format
 * getDate() returns the String value of date in yyyy.MM.dd format
 * */
public class DateUtils {
public static String getTimeStamp() {
return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
}
public static String getDate() {
return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
}
}
