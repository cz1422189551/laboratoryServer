package com.lq.laboratory.util;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParamUtil {

    public static Map createMap(Date date) throws ParseException {
        String dateStr = DateUtil.DateToStr(date);
        String[] split = dateStr.split("-");
        return createMap(split[0], split[1], split[2]);
    }


    public static Map createMap(int year) {
        return createMap(year, -1, -1);
    }

    public static Map createMap(int year, int month) {
        return createMap(year, month, -1);
    }

    public static Map createMap(int year, int month, int day) {
        String yearStr = year != -1 ? year + "" : "";
        String monthStr = month != -1 ? month + "" : "";
        String dayStr = day != -1 ? day + "" : "";
        return createMap(yearStr, monthStr, dayStr);
    }

    public static Map createMap(String year) {
        return createMap(year, "", "");
    }

    public static Map createMap(String year, String month) {
        return createMap(year, month, "");
    }


    public static Map createMap(String year, String month, String day) {
        Map<String, String> map = new HashMap<>();
        map.put("year", year);
        map.put("month", month);
        map.put("day", day);
        return map;
    }
}
