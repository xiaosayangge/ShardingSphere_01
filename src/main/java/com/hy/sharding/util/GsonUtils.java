/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

package com.hy.sharding.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/**
 * Gons工具类
 * Created by xuzhuo on 2016/12/12.
 */
public class GsonUtils {
    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    
    private static final Gson gsonFormatDate = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    
    private static final Gson gsonFormat = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static Gson createGson(){
        return gson;
    }

    public static Gson createGsonFormat(){
        return gsonFormat;
    }

    public static <T> String toJson(T t){
        return gson.toJson(t);
    }

    public static <T> String toJsonFormatDate(T t){
        return gsonFormatDate.toJson(t);
    }
    
    public static <T> String toJsonFormat(T t){
        return gsonFormat.toJson(t);
    }

    public static <T> T fromJson(String json, Class<T> clazzT){
        return gson.fromJson(json, clazzT);
    }

    public static <T> T fromJson(String json , Type type){
        return gson.fromJson(json, type);
    }

    public static <T> T fromJsonFormat(String json, Class<T> clazzT){
        return gsonFormat.fromJson(json, clazzT);
    }

    public static <T> T fromJsonFormat(String json, Type type){
        return gsonFormat.fromJson(json, type);
    }
}
