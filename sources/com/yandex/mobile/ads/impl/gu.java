package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public final class gu {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final List<gz> b = new CopyOnWriteArrayList();

    public final void a(@NonNull Context context, @NonNull gz gzVar) {
        synchronized (this.a) {
            this.b.add(gzVar);
            gt.a(context).a(gzVar);
        }
    }

    public final void a(@NonNull Context context) {
        synchronized (this.a) {
            gt a3 = gt.a(context);
            for (gz gzVar : this.b) {
                a3.b(gzVar);
            }
            this.b.clear();
        }
    }
}
