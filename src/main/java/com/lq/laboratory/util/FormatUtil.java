package com.lq.laboratory.util;


import com.lq.laboratory.exception.FormatException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.lq.laboratory.util.Const.ADMIN;
import static com.lq.laboratory.util.Const.STUDENT;
import static com.lq.laboratory.util.Const.TEACHER;

public class FormatUtil {


    public static int getPageAfterRemove(Map<String, String> map, String key) {
        int pageSize = Integer.valueOf(map.get(key));
        map.remove(key);
        return pageSize;
    }

    public static boolean isEmpty(String s) {
        if (s == null | "".equals(s)) return true;
        return false;
    }


    public static String userTypeToStr(int type) {
        switch (type) {
            case STUDENT:
                return "学生";
            case TEACHER:
                return "教师";
            case ADMIN:
                return "管理员";
            default:
                return "";
        }

    }

}
