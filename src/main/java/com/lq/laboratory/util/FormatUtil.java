package com.lq.laboratory.util;


import com.lq.laboratory.exception.FormatException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class FormatUtil {

    public static char changeRow(int rolIndex) {
        if (rolIndex == 0) throw new FormatException("座位行数不能为0");
        int rs = (64) + rolIndex;
        if (rs > rs + 25) throw new FormatException("座位行数不能大于26");
        return (char) rs;
    }

    public static int getPageAfterRemove(Map<String, String> map , String key) {
        int pageSize = Integer.valueOf(map.get(key));
        map.remove(key);
        return pageSize;
    }

}
