package vip.kuaifan.weiui.extend.module;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import vip.kuaifan.weiui.extend.integration.fastjson.JSONArray;
import vip.kuaifan.weiui.extend.integration.fastjson.JSONException;
import vip.kuaifan.weiui.extend.integration.fastjson.JSONObject;

/**
 * 处理 Map
 */
public class weiuiMap {

    @SuppressWarnings("unchecked")
    public static Map<String, Object> objectToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (Map<String, Object>) obj;
        }
        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}