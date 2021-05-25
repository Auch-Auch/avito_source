package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.Map;
import java.util.WeakHashMap;
public final class ak {
    private static final Object a = new Object();
    private static volatile ak b;
    @NonNull
    private final Map<a, Object> c = new WeakHashMap();

    public interface a {
        void a(@NonNull Context context, @NonNull fz fzVar);
    }

    private ak() {
    }

    public static ak a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new ak();
                }
            }
        }
        return b;
    }

    public final void a(@NonNull a aVar) {
        synchronized (a) {
            if (!this.c.containsKey(aVar)) {
                this.c.put(aVar, null);
            }
        }
    }

    public final void a(@NonNull Context context, @NonNull fz fzVar) {
        synchronized (a) {
            fy.a().a(context, fzVar);
            for (a aVar : this.c.keySet()) {
                aVar.a(context, fzVar);
            }
        }
    }
}
