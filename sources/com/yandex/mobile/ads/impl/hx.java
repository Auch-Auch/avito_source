package com.yandex.mobile.ads.impl;

import android.os.Build;
import android.support.annotation.NonNull;
public final class hx implements hz {
    @NonNull
    private final ib a = new ib();

    @Override // com.yandex.mobile.ads.impl.hz
    @NonNull
    public final String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("com.yandex.mobile.metrica.ads.sdk/");
        StringBuilder sb3 = new StringBuilder("2.150");
        if (sb3.length() - sb3.indexOf(".") < 3) {
            sb3.append("0");
        }
        sb2.append(sb3.toString());
        sb2.append(".39");
        sb.append(sb2.toString());
        StringBuilder sb4 = new StringBuilder("(");
        String str2 = Build.MODEL;
        String str3 = Build.MANUFACTURER;
        if (str2.startsWith(str3)) {
            str = ih.a(str2);
        } else {
            str = ih.a(str3) + " " + str2;
        }
        sb4.append(str);
        sb4.append("; Android ");
        sb4.append(Build.VERSION.RELEASE);
        sb4.append(")");
        sb.append(sb4.toString());
        return sb.toString();
    }
}
