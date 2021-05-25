package com.yandex.metrica;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.metrica.impl.ob.dq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public final class p {
    private static final List<String> sAllIdentifiers = Arrays.asList("yandex_mobile_metrica_uuid", "yandex_mobile_metrica_device_id", "appmetrica_device_id_hash", "yandex_mobile_metrica_get_ad_url", "yandex_mobile_metrica_report_ad_url");

    public interface Ucc {
        void onError(@NonNull String str);

        void onResult(@NonNull JSONObject jSONObject);
    }

    @Deprecated
    public static void a(IIdentifierCallback iIdentifierCallback) {
        a(iIdentifierCallback, sAllIdentifiers);
    }

    @NonNull
    @Deprecated
    public static YandexMetricaConfig cpcwh(YandexMetricaConfig yandexMetricaConfig, String str) {
        return dq.a(yandexMetricaConfig, str);
    }

    @Nullable
    @Deprecated
    public static Integer gbc(Context context) {
        return dq.c(context.getApplicationContext());
    }

    @NonNull
    public static String gcni(@NonNull Context context) {
        return dq.b(context);
    }

    @NonNull
    public static DeviceInfo gdi(@NonNull Context context) {
        return dq.a(context);
    }

    @Nullable
    public static String gdid(@NonNull Context context) {
        return dq.e(context);
    }

    @Nullable
    @Deprecated
    public static Location glkl(Context context) {
        return dq.g(context);
    }

    @NonNull
    public static String gmsvn(int i) {
        return dq.a(i);
    }

    public static void guc(@NonNull Ucc ucc, boolean z) {
        dq.a(ucc, z);
    }

    @Nullable
    @Deprecated
    public static String guid() {
        return dq.c();
    }

    public static boolean iifa() {
        return dq.a();
    }

    @NonNull
    public static String mpn(Context context) {
        return dq.f(context);
    }

    @Nullable
    public static String pgai() {
        try {
            return dq.b().get();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static Boolean plat() {
        try {
            return dq.d().get();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void rce(int i, String str, String str2, Map<String, String> map) {
        dq.a(i, str, str2, map);
    }

    @Deprecated
    public static void rolu(Context context, Object obj) {
        dq.a(context, obj);
    }

    public static void seb() {
        dq.e();
    }

    public static void slte(Context context, boolean z) {
        dq.a(context, z);
    }

    @NonNull
    public static String u(@NonNull String str) {
        return dq.a(str);
    }

    @Deprecated
    public static void urolu(Context context, Object obj) {
        dq.b(context, obj);
    }

    @Deprecated
    public static void a(IIdentifierCallback iIdentifierCallback, @NonNull List<String> list) {
        dq.a(iIdentifierCallback, new ArrayList(list));
    }

    @Nullable
    public static String guid(@NonNull Context context) {
        return dq.d(context);
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback, @NonNull List<String> list) {
        dq.a(context, iIdentifierCallback, new ArrayList(list));
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback, @NonNull String... strArr) {
        a(context, iIdentifierCallback, Arrays.asList(strArr));
    }

    public static void a(Context context, IIdentifierCallback iIdentifierCallback) {
        a(context, iIdentifierCallback, sAllIdentifiers);
    }
}
