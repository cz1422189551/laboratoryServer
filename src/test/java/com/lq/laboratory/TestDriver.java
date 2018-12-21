package com.lq.laboratory;

import com.lq.laboratory.util.DateUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDate;

public class TestDriver {
    
    @Test
    public void testUrlEncode() throws UnsupportedEncodingException {
        String json ="{\"timestamp\":\"2018-12-06T10:12:12.124+0000\",\"status\":500,\"error\":\"Internal Server Error\",\"message\":\"No message available\",\"path\":\"/user/update\"}";
        String decode = URLDecoder.decode(json, "UTF-8");
        System.out.println();
    }
    
    @Test
    public void test(){
        float num1 = 15.0f;
        float num2 = 8.0f;
        System.out.println(Math.round(num1/num2));
    }

    @Test
    public void testLocalDateToDate(){
        LocalDate now = LocalDate.now();
    }
    
}
