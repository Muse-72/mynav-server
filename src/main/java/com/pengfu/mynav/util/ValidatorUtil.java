package com.pengfu.mynav.util;

import java.lang.reflect.Field;

/**
 * 字段验证工具
 * @author PrideZH
 * @date 2021/10/26 - 12:43
 */
public class ValidatorUtil {

    private ValidatorUtil() { }

    public static boolean isExistEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            for(Field field : obj.getClass().getDeclaredFields()){
                // 私有属性公有化
                field.setAccessible(true);
                if(field.get(obj) == null || "".equals(field.get(obj))) {
                    return true;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean isExistEmpty(Object obj, String... fieldNames) {
        try {
            for (String fieldName : fieldNames) {
                Field field = obj.getClass().getField(fieldName);
                field.setAccessible(true);
                if(field.get(obj) == null || "".equals(field.get(obj))) {
                    return true;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

}
