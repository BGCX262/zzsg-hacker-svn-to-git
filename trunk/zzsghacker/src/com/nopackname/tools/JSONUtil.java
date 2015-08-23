package com.nopackname.tools;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopackname.response.API_MY_GEN_MOD_REINIT_RESPONSE;

public class JSONUtil {
    static ObjectMapper mapper = null;

    public static void generateJSON(Object o, OutputStream os) {
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = getMapper().getFactory().createGenerator(os);
            jsonGenerator.writeObject(o);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String generateJSON(Object o) {
        String result = "";
        JsonGenerator jsonGenerator = null;
        StringWriter writer = null;
        try {
            writer = new StringWriter();
            jsonGenerator = getMapper().getFactory().createGenerator(writer);
            jsonGenerator.writeObject(o);
            result = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static Object parseObject(String json,
            @SuppressWarnings("rawtypes") Class clazz) {
        try {
            return getMapper().readValue(json, clazz);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static ObjectMapper getMapper() {
        if (null == mapper) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    public static void main(String[] args) {
        API_MY_GEN_MOD_REINIT_RESPONSE resp = new API_MY_GEN_MOD_REINIT_RESPONSE();
        resp.setCt(1);
        resp.setExp(999999);
        resp.setIt(123);
        resp.setMoney(5000);
        resp.setWt(2);
        System.out.println(JSONUtil.generateJSON(resp));
    }
}
