package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public final class dt {
    public static final long a = ((long) (Math.floor(Math.random() * 4.294967295E9d) + 1.0d));

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(WebView webView) {
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    @Nullable
    public static Integer c(@Nullable String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static boolean a(ad adVar) {
        return adVar == null || adVar.a_();
    }

    public static ResultReceiver a(ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return resultReceiver2;
    }

    public static boolean b(Context context) {
        try {
            return WebViewDatabase.getInstance(context) != null;
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static void a(WebView webView) {
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static Bitmap a(String str) {
        try {
            String substring = str.substring(str.indexOf(",") + 1);
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            byte[] decode = Base64.decode(substring, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(@NonNull Context context) {
        return context.getSharedPreferences("YadPreferenceFile", 0).getString("SessionData", null);
    }

    public static void a(@NonNull Context context, @NonNull String str) {
        context.getSharedPreferences("YadPreferenceFile", 0).edit().putString("SessionData", str).apply();
    }

    @Nullable
    public static Long a(@Nullable String str, @Nullable Long l) {
        if (str != null) {
            try {
                return Long.valueOf(str);
            } catch (NumberFormatException unused) {
            }
        }
        return l;
    }

    @NonNull
    public static <T> String a(T t) {
        return t.toString();
    }

    public static List<bo> a(@NonNull x xVar, Map<String, String> map) {
        List<String> f = xVar.f();
        List<Long> i = xVar.i();
        List<Integer> j = xVar.j();
        ArrayList arrayList = new ArrayList();
        if (f != null) {
            int i2 = 0;
            while (i2 < f.size()) {
                String a3 = a(f.get(i2), map);
                long longValue = i.size() > i2 ? i.get(i2).longValue() : 0;
                int intValue = j.size() > i2 ? j.get(i2).intValue() : 0;
                bo boVar = new bo();
                boVar.a(a3);
                boVar.a(longValue);
                boVar.a(intValue);
                arrayList.add(boVar);
                i2++;
            }
        }
        return arrayList;
    }

    private static String a(String str, Map<String, String> map) {
        if (map == null) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public static int a(@NonNull JSONObject jSONObject, @NonNull String str, int i) {
        int optInt = jSONObject.optInt(str, i);
        return optInt >= 0 ? optInt : i;
    }
}
