package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class CameraEffectJSONUtility {
    public static final Map<Class<?>, Setter> a;

    public interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    public static class a implements Setter {
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
            builder.putArgument(str, (String) obj);
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            jSONObject.put(str, obj);
        }
    }

    public static class b implements Setter {
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
            throw new IllegalArgumentException("Unexpected type from JSON");
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : (String[]) obj) {
                jSONArray.put(str2);
            }
            jSONObject.put(str, jSONArray);
        }
    }

    public static class c implements Setter {
        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
            JSONArray jSONArray = (JSONArray) obj;
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof String) {
                    strArr[i] = (String) obj2;
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unexpected type in an array: ");
                    L.append(obj2.getClass());
                    throw new IllegalArgumentException(L.toString());
                }
            }
            builder.putArgument(str, strArr);
        }

        @Override // com.facebook.share.internal.CameraEffectJSONUtility.Setter
        public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
            throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(String.class, new a());
        hashMap.put(String[].class, new b());
        hashMap.put(JSONArray.class, new c());
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(obj == null || obj == JSONObject.NULL)) {
                Setter setter = a.get(obj.getClass());
                if (setter != null) {
                    setter.setOnArgumentsBuilder(builder, next, obj);
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unsupported type: ");
                    L.append(obj.getClass());
                    throw new IllegalArgumentException(L.toString());
                }
            }
        }
        return builder.build();
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = a.get(obj.getClass());
                if (setter != null) {
                    setter.setOnJSON(jSONObject, str, obj);
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unsupported type: ");
                    L.append(obj.getClass());
                    throw new IllegalArgumentException(L.toString());
                }
            }
        }
        return jSONObject;
    }
}
