package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public final class adu {
    private final Class<? extends adw> a;
    private final boolean b;
    private final String c;

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends com.yandex.metrica.impl.ob.adw> */
    private adu(@NonNull adw<?> adw, boolean z, @NonNull String str) {
        this.a = adw.getClass();
        this.b = z;
        this.c = str;
    }

    public final boolean a() {
        return this.b;
    }

    @NonNull
    public final String b() {
        return this.c;
    }

    public static final adu a(@NonNull adw<?> adw) {
        return new adu(adw, true, "");
    }

    public static final adu a(@NonNull adw<?> adw, @NonNull String str) {
        return new adu(adw, false, str);
    }
}
