package com.lq.laboratory;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestDriver {
    
    @Test
    public void testUrlEncode() throws UnsupportedEncodingException {
        String json ="{\"timestamp\":\"2018-12-06T10:12:12.124+0000\",\"status\":500,\"error\":\"Internal Server Error\",\"message\":\"No message available\",\"path\":\"/user/update\"}";
        String decode = URLDecoder.decode(json, "UTF-8");
        System.out.println();
    }
    
}
