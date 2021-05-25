package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.preferences.GeoContract;
import com.yandex.metrica.impl.ob.ve;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class abc {

    public static class a extends JSONObject {
        public a() {
        }

        public String a(String str) {
            if (super.has(str)) {
                try {
                    return super.getString(str);
                } catch (Throwable unused) {
                }
            }
            return "";
        }

        public String b(String str) {
            return super.has(str) ? a(str) : "";
        }

        public boolean c(String str) {
            try {
                return JSONObject.NULL != super.get(str);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Nullable
        public Long d(String str) {
            try {
                return Long.valueOf(getLong(str));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Nullable
        public Boolean e(String str) {
            try {
                return Boolean.valueOf(getBoolean(str));
            } catch (Throwable unused) {
                return null;
            }
        }

        public a(String str) throws JSONException {
            super(str);
        }

        public Object a(String str, Object obj) {
            try {
                return super.get(str);
            } catch (Throwable unused) {
                return obj;
            }
        }
    }

    @VisibleForTesting
    public static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(a(Array.get(obj, i)));
                }
                return new JSONArray((Collection) arrayList);
            } else if (obj instanceof Collection) {
                Collection<Object> collection = (Collection) obj;
                ArrayList arrayList2 = new ArrayList(collection.size());
                for (Object obj2 : collection) {
                    arrayList2.add(a(obj2));
                }
                return new JSONArray((Collection) arrayList2);
            } else if (!(obj instanceof Map)) {
                return obj;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    String obj3 = entry.getKey().toString();
                    if (obj3 != null) {
                        linkedHashMap.put(obj3, a(entry.getValue()));
                    }
                }
                return new JSONObject(linkedHashMap);
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String b(@Nullable Map map) {
        if (dl.a(map)) {
            return null;
        }
        if (dl.a(19)) {
            return new JSONObject(map).toString();
        }
        return a((Object) map).toString();
    }

    @Nullable
    public static List<String> c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (Throwable unused) {
                }
            }
            return arrayList;
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Nullable
    public static Boolean d(@Nullable JSONObject jSONObject, @NonNull String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return Boolean.valueOf(jSONObject.getBoolean(str));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Nullable
    public static Float e(@Nullable JSONObject jSONObject, @NonNull String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return Float.valueOf((float) jSONObject.getDouble(str));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static aah d(@NonNull JSONObject jSONObject) throws JSONException {
        ve.a.k kVar = new ve.a.k();
        return new aah(jSONObject.optBoolean("tsc", kVar.b), jSONObject.optBoolean("rtsc1", kVar.c), jSONObject.optBoolean("tvc", kVar.d), jSONObject.optBoolean("tsc1", kVar.e), jSONObject.optBoolean("ic", kVar.j), jSONObject.optBoolean("ncvc", kVar.k), jSONObject.optBoolean("tlc", kVar.l), jSONObject.optInt("tltb", kVar.f), jSONObject.optInt("ttb", kVar.g), jSONObject.optInt("mec", kVar.h), jSONObject.optInt("mfcl", kVar.i));
    }

    @NonNull
    public static HashMap<String, String> b(@NonNull String str) throws JSONException {
        return a(new JSONObject(str));
    }

    @Nullable
    public static String b(@Nullable JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Nullable
    public static Integer c(@Nullable JSONObject jSONObject, @NonNull String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return Integer.valueOf(jSONObject.getInt(str));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static aag b(@NonNull JSONObject jSONObject) throws JSONException {
        aap aap;
        aah aah;
        ve.a.b bVar = new ve.a.b();
        JSONObject optJSONObject = jSONObject.optJSONObject("upc");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("uecc");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("ucfbc");
        boolean optBoolean = jSONObject.optBoolean("upe", bVar.v);
        boolean optBoolean2 = jSONObject.optBoolean("uece", bVar.w);
        boolean optBoolean3 = jSONObject.optBoolean("ucfbe", bVar.x);
        aah aah2 = null;
        if (optJSONObject == null) {
            aap = null;
        } else {
            aap = c(optJSONObject);
        }
        if (optJSONObject2 == null) {
            aah = null;
        } else {
            aah = d(optJSONObject2);
        }
        if (optJSONObject3 != null) {
            aah2 = d(optJSONObject3);
        }
        return new aag(optBoolean, optBoolean2, optBoolean3, aap, aah, aah2);
    }

    private static aap c(@NonNull JSONObject jSONObject) throws JSONException {
        ve.a.l lVar = new ve.a.l();
        return new aap(jSONObject.optInt("tltb", lVar.b), jSONObject.optInt("ttb", lVar.c), jSONObject.optInt("mvcl", lVar.d), jSONObject.optLong("act", lVar.e), jSONObject.optBoolean("rtsc", lVar.f));
    }

    @Nullable
    public static String a(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return "";
        }
        return b(map);
    }

    @Nullable
    public static String a(List<String> list) {
        if (dl.a((Collection) list)) {
            return null;
        }
        if (dl.a(19)) {
            return new JSONArray((Collection) list).toString();
        }
        return a((Object) list).toString();
    }

    @Nullable
    public static HashMap<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (JSONObject.NULL.equals(jSONObject)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    @Nullable
    public static JSONObject a(@NonNull JSONObject jSONObject, @NonNull dp dpVar) throws JSONException {
        jSONObject.put("lat", dpVar.getLatitude());
        jSONObject.put(MessageBody.Location.LONGITUDE, dpVar.getLongitude());
        jSONObject.putOpt("timestamp", Long.valueOf(dpVar.getTime()));
        jSONObject.putOpt("precision", dpVar.hasAccuracy() ? Float.valueOf(dpVar.getAccuracy()) : null);
        jSONObject.putOpt("direction", dpVar.hasBearing() ? Float.valueOf(dpVar.getBearing()) : null);
        jSONObject.putOpt("speed", dpVar.hasSpeed() ? Float.valueOf(dpVar.getSpeed()) : null);
        jSONObject.putOpt("altitude", dpVar.hasAltitude() ? Double.valueOf(dpVar.getAltitude()) : null);
        jSONObject.putOpt(GeoContract.PROVIDER, dh.c(dpVar.getProvider(), null));
        jSONObject.putOpt("original_provider", dpVar.a());
        return jSONObject;
    }

    @Nullable
    public static Long a(@Nullable JSONObject jSONObject, @NonNull String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return Long.valueOf(jSONObject.getLong(str));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean a(@Nullable JSONObject jSONObject, @NonNull String str, boolean z) {
        Boolean d = d(jSONObject, str);
        return d == null ? z : d.booleanValue();
    }

    @Nullable
    public static byte[] a(@NonNull JSONObject jSONObject, @NonNull String str, byte[] bArr) {
        String b = b(jSONObject, str);
        if (b == null) {
            return bArr;
        }
        try {
            return dh.e(b);
        } catch (Throwable unused) {
            return bArr;
        }
    }

    public static List<String> a(@Nullable JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static JSONArray a(zb[] zbVarArr) {
        JSONArray jSONArray = new JSONArray();
        if (zbVarArr != null) {
            for (zb zbVar : zbVarArr) {
                try {
                    jSONArray.put(a(zbVar));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject a(zb zbVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cell_id", zbVar.e());
        jSONObject.put("signal_strength", zbVar.a());
        jSONObject.put("lac", zbVar.d());
        jSONObject.put("country_code", zbVar.b());
        jSONObject.put("operator_id", zbVar.c());
        jSONObject.put("operator_name", zbVar.f());
        jSONObject.put("is_connected", zbVar.h());
        jSONObject.put("cell_type", zbVar.i());
        jSONObject.put("pci", zbVar.j());
        jSONObject.put("last_visible_time_offset", zbVar.k());
        return jSONObject;
    }

    public static JSONObject a() throws JSONException {
        return new JSONObject().put("stat_sending", new JSONObject().put("disabled", true));
    }

    public static JSONObject a(@NonNull aag aag) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject put = new JSONObject().put("upe", aag.a).put("uece", aag.b).put("ucfbe", aag.c);
        aap aap = aag.d;
        JSONObject jSONObject3 = null;
        if (aap == null) {
            jSONObject = null;
        } else {
            jSONObject = a(aap);
        }
        JSONObject putOpt = put.putOpt("upc", jSONObject);
        aah aah = aag.e;
        if (aah == null) {
            jSONObject2 = null;
        } else {
            jSONObject2 = a(aah);
        }
        JSONObject putOpt2 = putOpt.putOpt("uecc", jSONObject2);
        aah aah2 = aag.f;
        if (aah2 != null) {
            jSONObject3 = a(aah2);
        }
        return putOpt2.putOpt("ucfbc", jSONObject3);
    }

    private static JSONObject a(@NonNull aap aap) throws JSONException {
        return new JSONObject().put("tltb", aap.a).put("ttb", aap.b).put("mvcl", aap.c).put("act", aap.d).put("rtsc", aap.e);
    }

    private static JSONObject a(@NonNull aah aah) throws JSONException {
        return new JSONObject().put("tsc", aah.a).put("rtsc1", aah.b).put("tvc", aah.c).put("tsc1", aah.d).put("ic", aah.e).put("ncvc", aah.f).put("tlc", aah.g).put("tltb", aah.h).put("ttb", aah.i).put("mec", aah.j).put("mfcl", aah.k);
    }
}
