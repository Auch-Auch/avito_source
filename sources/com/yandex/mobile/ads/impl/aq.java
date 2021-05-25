package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public final class aq {
    @NonNull
    private static final Object a = new Object();
    @Nullable
    private static volatile aq b;
    @NonNull
    private final List<String> c = new ArrayList();
    @NonNull
    private final List<String> d = new ArrayList();

    private aq() {
    }

    public static aq a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new aq();
                }
            }
        }
        return b;
    }

    public final void b(String str) {
        synchronized (a) {
            this.d.add(str);
        }
    }

    @NonNull
    public final List<String> c() {
        ArrayList arrayList;
        synchronized (a) {
            arrayList = new ArrayList(this.d);
        }
        return arrayList;
    }

    @NonNull
    public final List<String> b() {
        ArrayList arrayList;
        synchronized (a) {
            arrayList = new ArrayList(this.c);
        }
        return arrayList;
    }

    public final void a(String str) {
        synchronized (a) {
            this.c.add(str);
        }
    }
}
