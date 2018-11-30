package com.lq.laboratory.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lq.laboratory.entity.ResponseEntity;
import com.lq.laboratory.entity.User;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;

public class JsonUtils {

    static Gson gson = new GsonBuilder().create();


    public static String toJson(Object target) {
        return gson.toJson(target);
    }
}
