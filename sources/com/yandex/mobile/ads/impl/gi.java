package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.metrica.IIdentifierCallback;
public final class gi {
    @NonNull
    private final gj a = new gj();

    @NonNull
    public static String a() {
        return a("Connection timeout");
    }

    @NonNull
    public static String b() {
        return a("Incorrect integration");
    }

    @NonNull
    public static String c() {
        return a("Invalid response");
    }

    @NonNull
    public static String a(@NonNull IIdentifierCallback.Reason reason) {
        return a(gj.a(reason));
    }

    @NonNull
    private static String a(@NonNull String str) {
        return "Internal state wasn't completely configured. " + str + ".";
    }
}
