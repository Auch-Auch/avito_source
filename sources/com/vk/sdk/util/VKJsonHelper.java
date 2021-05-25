package com.vk.sdk.util;

import com.vk.sdk.api.model.VKApiModel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class VKJsonHelper {
    public static Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return toMap((JSONObject) obj);
        }
        return obj instanceof JSONArray ? toList((JSONArray) obj) : obj;
    }

    public static Map<String, Object> getMap(JSONObject jSONObject, String str) throws JSONException {
        return toMap(jSONObject.getJSONObject(str));
    }

    public static boolean isEmptyObject(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public static Object toArray(JSONArray jSONArray, Class cls) {
        Object newInstance = Array.newInstance(cls.getComponentType(), jSONArray.length());
        Class<?> componentType = cls.getComponentType();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                Object newInstance2 = componentType.newInstance();
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (newInstance2 instanceof VKApiModel) {
                        ((VKApiModel) newInstance2).parse(jSONObject);
                        Array.set(newInstance, i, (VKApiModel) newInstance2);
                    }
                }
            } catch (IllegalAccessException | InstantiationException | JSONException unused) {
            }
        }
        return newInstance;
    }

    public static Object toJSON(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                jSONObject.put(obj2.toString(), toJSON(map.get(obj2)));
            }
            return jSONObject;
        } else if (!(obj instanceof Iterable)) {
            return obj;
        } else {
            JSONArray jSONArray = new JSONArray();
            for (Object obj3 : (Iterable) obj) {
                jSONArray.put(obj3);
            }
            return jSONArray;
        }
    }

    public static List toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)));
        }
        return hashMap;
    }
}
