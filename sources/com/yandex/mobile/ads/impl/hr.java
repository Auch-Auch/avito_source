package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
public final class hr {
    public static final int a;
    public static final int b;
    public static final int c;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = (int) timeUnit.toMillis(10);
        b = (int) timeUnit.toMillis(30);
        c = (int) timeUnit.toMillis(3);
    }
}
