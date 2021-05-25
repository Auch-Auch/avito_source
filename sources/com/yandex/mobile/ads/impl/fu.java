package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public final class fu {
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final ft b;
    @NonNull
    private final List<fx> c = new CopyOnWriteArrayList();

    public fu(@NonNull fq fqVar) {
        this.b = new ft(fqVar);
    }

    public final void a(@NonNull Context context, @NonNull fw fwVar, @NonNull fx fxVar) {
        synchronized (this.a) {
            boolean a3 = fq.a(context);
            fz a4 = fy.a().a(context);
            if (ar.b() && !a3 && a4 != null && a4.l()) {
                synchronized (this.a) {
                    this.c.add(fxVar);
                    fwVar.b(fxVar);
                }
            } else {
                fxVar.a(null);
            }
        }
    }

    public final void a(@NonNull fw fwVar) {
        synchronized (this.a) {
            for (fx fxVar : this.c) {
                fwVar.a(fxVar);
            }
            this.c.clear();
        }
    }
}
