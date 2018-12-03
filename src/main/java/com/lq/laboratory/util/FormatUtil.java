package com.lq.laboratory.util;


import com.lq.laboratory.exception.FormatException;

public class FormatUtil {

    public static char changeRow(int rolIndex) {
        if (rolIndex == 0) throw new FormatException("座位行数不能为0");
        int rs = (64) + rolIndex;
        if (rs > rs + 25) throw new FormatException("座位行数不能大于26");

        return (char) rs;
    }
}
