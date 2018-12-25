package com.lq.laboratory.util;


import com.lq.laboratory.exception.FormatException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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


}
