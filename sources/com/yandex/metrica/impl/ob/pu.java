package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class pu extends z<Location> {
    @NonNull
    private final qr a;

    public pu(@Nullable y<Location> yVar, @NonNull qr qrVar) {
        super(yVar);
        this.a = qrVar;
    }

    /* renamed from: a */
    public void b(@Nullable Location location) {
        if (location != null) {
            this.a.a((qr) location);
        }
    }
}
