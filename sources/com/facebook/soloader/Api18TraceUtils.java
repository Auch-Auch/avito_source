package com.facebook.soloader;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.os.Trace;
import javax.annotation.Nullable;
@DoNotOptimize
@TargetApi(18)
public class Api18TraceUtils {
    public static void a(String str, @Nullable String str2, String str3) {
        String e3 = a.e3(str, str2, str3);
        if (e3.length() > 127 && str2 != null) {
            StringBuilder L = a.L(str);
            L.append(str2.substring(0, (127 - str.length()) - str3.length()));
            L.append(str3);
            e3 = L.toString();
        }
        Trace.beginSection(e3);
    }
}
