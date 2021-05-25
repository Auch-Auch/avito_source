package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.Locale;
public final class cg {
    private static final ado a = new ado();
    private static final abi<Integer, a> b;
    @TargetApi(23)
    private static final abi<Integer, a> c;
    private static final abi<a, Integer> d = new abi<a, Integer>(2) { // from class: com.yandex.metrica.impl.ob.cg.5
        {
            a(a.CELL, 0);
            a(a.WIFI, 1);
            a(a.BLUETOOTH, 3);
            a(a.ETHERNET, 4);
            a(a.MOBILE_DUN, 5);
            a(a.MOBILE_HIPRI, 6);
            a(a.MOBILE_MMS, 7);
            a(a.MOBILE_SUPL, 8);
            a(a.VPN, 9);
            a(a.WIMAX, 10);
            a(a.LOWPAN, 11);
            a(a.WIFI_AWARE, 12);
        }
    };

    public enum a {
        WIFI,
        CELL,
        ETHERNET,
        BLUETOOTH,
        VPN,
        LOWPAN,
        WIFI_AWARE,
        MOBILE_DUN,
        MOBILE_HIPRI,
        MOBILE_MMS,
        MOBILE_SUPL,
        WIMAX,
        OFFLINE,
        UNDEFINED
    }

    public static final class b {
        private static final String[] a = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

        public static boolean a() {
            try {
                return new File("/system/app/Superuser.apk").exists();
            } catch (Throwable unused) {
                return false;
            }
        }

        public static boolean b() {
            String[] strArr = a;
            for (String str : strArr) {
                try {
                    if (new File(str + "su").exists()) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        public static int c() {
            return (a() || b()) ? 1 : 0;
        }
    }

    static {
        a aVar = a.UNDEFINED;
        b = new abi<Integer, a>(aVar) { // from class: com.yandex.metrica.impl.ob.cg.3
            {
                a(1, a.WIFI);
                a(0, a.CELL);
                if (dl.a(13)) {
                    a(7, a.BLUETOOTH);
                    a(9, a.ETHERNET);
                }
                a(4, a.MOBILE_DUN);
                a(5, a.MOBILE_HIPRI);
                a(2, a.MOBILE_MMS);
                a(3, a.MOBILE_SUPL);
                a(6, a.WIMAX);
                if (dl.a(21)) {
                    a(17, a.VPN);
                }
            }
        };
        c = new abi<Integer, a>(aVar) { // from class: com.yandex.metrica.impl.ob.cg.4
            {
                a(1, a.WIFI);
                a(0, a.CELL);
                a(3, a.ETHERNET);
                a(2, a.BLUETOOTH);
                a(4, a.VPN);
                if (dl.a(27)) {
                    a(6, a.LOWPAN);
                }
                if (dl.a(26)) {
                    a(5, a.WIFI_AWARE);
                }
            }
        };
    }

    public static Integer c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra <= -1 || intExtra2 <= 0) {
            return null;
        }
        return Integer.valueOf(Math.round((((float) intExtra) / ((float) intExtra2)) * 100.0f));
    }

    @NonNull
    public static a d(@NonNull Context context) {
        return (a) dl.a(new aca<ConnectivityManager, a>() { // from class: com.yandex.metrica.impl.ob.cg.6
            public a a(@NonNull ConnectivityManager connectivityManager) throws Throwable {
                if (dl.a(23)) {
                    return cg.c(connectivityManager);
                }
                return cg.d(connectivityManager);
            }
        }, (ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", a.UNDEFINED);
    }

    public static int e(@NonNull Context context) {
        return a(d(context));
    }

    @NonNull
    public static com.yandex.metrica.b a(@NonNull Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Point b2 = b(context);
        int i = b2.x;
        int i2 = b2.y;
        float f = displayMetrics.density;
        float f2 = (float) i;
        float f3 = (float) i2;
        float min = Math.min(f2 / f, f3 / f);
        float f4 = f * 160.0f;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
        double sqrt = Math.sqrt((double) ((f6 * f6) + (f5 * f5)));
        if (a(context, sqrt)) {
            return com.yandex.metrica.b.TV;
        }
        if (sqrt >= 7.0d || min >= 600.0f) {
            return com.yandex.metrica.b.TABLET;
        }
        return com.yandex.metrica.b.PHONE;
    }

    @NonNull
    @TargetApi(17)
    public static Point b(Context context) {
        AnonymousClass1 r0 = new aca<WindowManager, Display>() { // from class: com.yandex.metrica.impl.ob.cg.1
            public Display a(@NonNull WindowManager windowManager) throws Throwable {
                return windowManager.getDefaultDisplay();
            }
        };
        return (Point) dl.a(new aca<Display, Point>() { // from class: com.yandex.metrica.impl.ob.cg.2
            public Point a(@NonNull Display display) throws Throwable {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }, (Display) dl.a(r0, (WindowManager) context.getSystemService("window"), "getting display", "WindowManager"), "getting display metrics", "Display", new Point(0, 0));
    }

    /* access modifiers changed from: private */
    @NonNull
    public static a d(@NonNull ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a.OFFLINE;
        }
        return b.a(Integer.valueOf(activeNetworkInfo.getType()));
    }

    @TargetApi(23)
    private static boolean b(@NonNull ConnectivityManager connectivityManager, @Nullable Network network) {
        if (network == null) {
            return true;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
        if (networkInfo == null || networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    @NonNull
    @TargetApi(23)
    public static a c(@NonNull ConnectivityManager connectivityManager) {
        a aVar = a.UNDEFINED;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (a(connectivityManager, activeNetwork)) {
            return a.OFFLINE;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            return aVar;
        }
        for (Integer num : c.a()) {
            if (networkCapabilities.hasTransport(num.intValue())) {
                return c.a(num);
            }
        }
        return aVar;
    }

    private static boolean a(Context context, double d2) {
        return d2 >= 15.0d && !a.b(context, "android.hardware.touchscreen");
    }

    @NonNull
    public static String a(@NonNull Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (dl.a(21)) {
            String script = locale.getScript();
            if (!TextUtils.isEmpty(script)) {
                sb.append('-');
                sb.append(script);
            }
        }
        if (!TextUtils.isEmpty(country)) {
            sb.append('_');
            sb.append(country);
        }
        return sb.toString();
    }

    private static boolean a(@NonNull ConnectivityManager connectivityManager, @Nullable Network network) {
        if (dl.a(29)) {
            return network == null;
        }
        return b(connectivityManager, network);
    }

    @VisibleForTesting
    public static int a(@Nullable a aVar) {
        return d.a(aVar).intValue();
    }
}
