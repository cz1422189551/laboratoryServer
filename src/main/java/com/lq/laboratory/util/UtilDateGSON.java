package com.lq.laboratory.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDateGSON implements JsonSerializer, JsonDeserializer {
 


 
    @Override
    public Date deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(arg0.getAsJsonPrimitive().getAsString());
        } catch (ParseException e) {

        }
 
        return date;
    }

    @Override
    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new JsonPrimitive(sdf.format(src));
    }
}
