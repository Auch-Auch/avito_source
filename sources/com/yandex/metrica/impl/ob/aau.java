package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class aau {
    public static boolean a(@Nullable Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static boolean b(@Nullable Boolean bool) {
        return !a(bool);
    }

    public static boolean c(@Nullable Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }
}
