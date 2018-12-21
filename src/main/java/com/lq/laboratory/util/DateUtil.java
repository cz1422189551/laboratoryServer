package com.lq.laboratory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm");

    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    //字符串转LocalDateTime
    public static LocalDateTime stringToLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, df);
    }

    //localDateTime转字符串
    public static String localDateTimeToStringDate(LocalDateTime dateTime) {
        return dateTime.format(df);
    }

    //Date转LocalDateTime
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    //Date转字符串
    public static String DateToString(Date date) {
        return sdf.format(date);
    }

    //LocalDateTime转Date
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

//    public static void main(String[] args) {
//        System.out.println(DateUtil.localDateToDate(LocalDate.now()));
//    }

    //LocalDate转Date
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zone);

        Date date = Date.from(zdt.toInstant());
        return date;
    }

    //字符串转Date 带时间
    public static Date stringToDateWithTime(String dateStr) throws ParseException {

        return sdf.parse(dateStr);
    }

    //字符串转Date
    public static Date stringToDate(String dateStr) throws ParseException {
        return sdf2.parse(dateStr);
    }

    //加上分钟
    public static LocalDateTime plus(Date date, int minute) {
        return dateToLocalDateTime(date).plusMinutes(minute);
    }

    //加上分钟
    public static Date addMinute(Date date, int minute) {
        return localDateTimeToDate(plus(date, minute));
    }

}
