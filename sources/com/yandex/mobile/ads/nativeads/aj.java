package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
public final class aj {
    private static final Object a = new Object();
    private static volatile aj b;
    @NonNull
    private final Map<View, ba> c = new WeakHashMap();

    @NonNull
    public static aj a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new aj();
                }
            }
        }
        return b;
    }

    @Nullable
    public final ba a(@NonNull View view) {
        ba baVar;
        synchronized (a) {
            baVar = this.c.get(view);
        }
        return baVar;
    }

    public final void a(@NonNull View view, @NonNull ba baVar) {
        synchronized (a) {
            this.c.put(view, baVar);
        }
    }

    public final boolean a(@NonNull ba baVar) {
        Iterator<Map.Entry<View, ba>> it = this.c.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().getValue() == baVar) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
