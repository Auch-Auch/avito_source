package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
public final class hy implements hz {
    @NonNull
    private static String b() {
        String str;
        try {
            str = System.getProperty("java.vm.version");
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "1.0.0" : str;
    }

    @Override // com.yandex.mobile.ads.impl.hz
    @NonNull
    public final String a() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dalvik/");
        sb.append(b());
        sb.append(" (Linux; U; Android ");
        String str2 = Build.VERSION.RELEASE;
        if (str2.length() <= 0) {
            str2 = "1.0";
        }
        sb.append(str2);
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str3 = Build.MODEL;
            if (str3.length() > 0) {
                sb.append("; ");
                sb.append(str3);
            }
        }
        String str4 = Build.ID;
        if (str4.length() > 0) {
            sb.append(" Build/");
            sb.append(str4);
        }
        sb.append(")");
        return sb.toString();
    }
}
