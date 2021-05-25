package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class bt {

    public interface a<T> {
        @Nullable
        T a(String str);
    }

    public static String a(Map<String, String> map, rq rqVar) {
        return map.get(rqVar.a());
    }

    public static boolean b(@NonNull Map<String, String> map, @NonNull rq rqVar) {
        String a3 = a(map, rqVar);
        if (a3 == null) {
            return false;
        }
        return Boolean.parseBoolean(a3);
    }

    public static int c(Map<String, String> map, rq rqVar) {
        return dt.b(a(map, rqVar));
    }

    @Nullable
    public static String d(@NonNull Map<String, String> map, @NonNull rq rqVar) {
        List<String> e = e(map, rqVar);
        if (e.isEmpty()) {
            return null;
        }
        return e.get(0);
    }

    @NonNull
    public static List<String> e(Map<String, String> map, rq rqVar) {
        return a(map, rqVar, new a<String>() { // from class: com.yandex.mobile.ads.impl.bt.1
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.yandex.mobile.ads.impl.bt.a
            @Nullable
            public final /* bridge */ /* synthetic */ String a(String str) {
                return str;
            }
        });
    }

    @NonNull
    public static <T> List<T> a(Map<String, String> map, rq rqVar, a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        String a3 = a(map, rqVar);
        if (!TextUtils.isEmpty(a3)) {
            for (String str : (String[]) id.a(a3.split(","))) {
                try {
                    String decode = URLDecoder.decode(str.trim(), "UTF-8");
                    if (aVar.a(decode) != null) {
                        arrayList.add(aVar.a(decode));
                    }
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }
}
