package com.lq.laboratory.util;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DateUtil {

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2018, 10, 2);

        LocalDate plusDays = now.plusDays(30);
        LocalDate weeks = now.plusWeeks(1);

        System.out.println("now  : " + now.toString());
        System.out.println("of  : " + of.toString());
        System.out.println(plusDays);
        System.out.println(weeks);
    }

    @Test
    public void testDayOfWeek() {
        System.out.println(LocalDate.now().getDayOfWeek());
        DayOfWeek plus = DayOfWeek.SUNDAY.plus(7);
        System.out.println(plus);

    }

    @Test
    public void testTemporalAdjuster() {
        LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);
        String format = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(
                LocalDateTime.of(2017, 1, 1, 9, 10, 0)
        );
        System.out.println(format);
    }

    @Test
    public void testDate() {


        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        System.out.println(format);
        String now = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        System.out.println(now);
    }

    @Test
    public void testCalendar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        List<String> resultList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.DATE, i);
            Date time = instance.getTime();
            resultList.add(sdf.format(time));
        }
        resultList.stream().forEach(System.out::println);
    }

    @Test
    public void testTs() {
        initAvailableTime();
    }


    @Test
    public void testMinutePlusAndDec() {
        String date = "2018-12-18 8:30";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");
        LocalDateTime parse = LocalDateTime.parse(date, df);
        LocalDateTime localDateTime = parse.plusMinutes(30);
        System.out.println(parse);
        System.out.println(localDateTime.format(df));
    }


    //初始化可用的时间
    public static List<String> initAvailableTime() {
        List<Integer> timeList = new ArrayList<>();
        for (int i = 1; i < (end - start + 1) * 2; i++) {
            int value = startTime + (baseTime * i);
            int rest = value / (baseTime) / 2;
            if (rest == 12 || rest == 13 || rest == 14) continue;
            timeList.add(value);
        }
        List<String> stringList = new ArrayList<>();

        for (Integer integer : timeList) {
            int value = integer / baseTime / 2;
            if (integer / baseTime % 2 != 0) {
                stringList.add(value + ":" + "30");
            } else {
                stringList.add(value + ":" + "00");
            }
        }

        return stringList;
    }

    //默认时间
    static int baseTime = 30;
    static int start = 8;
    static int end = 17;
    static int startTime = start * baseTime * 2;
}
