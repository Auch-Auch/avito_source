package com.yandex.metrica.impl.ob;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.regex.Pattern;
public class cx {
    private static final Pattern a = Pattern.compile(".*at com\\.yandex\\.metrica\\.push\\.*");
    private static final Pattern b = Pattern.compile(".*at com\\.yandex\\.metrica\\.(?!push)");

    public static void a() {
        dh.b("release");
    }

    @NonNull
    public static String b() {
        return a.a;
    }

    public static String c() {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        if (str.startsWith(str2)) {
            return dh.b(str);
        }
        return dh.b(str2) + " " + str;
    }

    public static String a(String str) {
        StringBuilder W = a2.b.a.a.a.W(str, "/", "3.13.1", ".", "72430");
        W.append(" (");
        W.append(c());
        W.append("; Android ");
        return a2.b.a.a.a.t(W, Build.VERSION.RELEASE, ")");
    }

    public static boolean b(Throwable th) {
        String a3 = dl.a(th);
        return !TextUtils.isEmpty(a3) && a.matcher(a3).find();
    }

    @VisibleForTesting
    public static class a {
        @NonNull
        public static final String a = new a().a();

        @VisibleForTesting
        @NonNull
        public String a() {
            if (a("com.unity3d.player.UnityPlayer")) {
                return "unity";
            }
            if (a("mono.MonoPackageManager")) {
                return "xamarin";
            }
            if (a("org.apache.cordova.CordovaPlugin")) {
                return "cordova";
            }
            return a("com.facebook.react.ReactRootView") ? "react" : AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
        }

        @VisibleForTesting
        public boolean a(String str) {
            return cx.b(str);
        }
    }

    public static boolean a(Throwable th) {
        String a3 = dl.a(th);
        return !TextUtils.isEmpty(a3) && b.matcher(a3).find();
    }

    public static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
