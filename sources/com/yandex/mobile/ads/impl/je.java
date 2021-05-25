package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
public final class je {
    private static volatile je a;
    private static final Object b = new Object();

    private je() {
    }

    @NonNull
    public static je a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new je();
                }
            }
        }
        return a;
    }

    @NonNull
    public static jd a(boolean z) {
        if (z) {
            return new jf();
        }
        return new jc();
    }
}
