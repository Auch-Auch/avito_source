package com.yandex.metrica.impl.ob;

import android.os.SystemClock;
import java.util.GregorianCalendar;
public final class abu {
    public static final long a() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static long b() {
        return System.currentTimeMillis() / 1000;
    }

    public static long c() {
        return abp.a().b();
    }

    public static long d() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static int a(long j) {
        return ((GregorianCalendar) GregorianCalendar.getInstance()).getTimeZone().getOffset(j * 1000) / 1000;
    }
}
