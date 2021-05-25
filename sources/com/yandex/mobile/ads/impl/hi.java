package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class hi implements he {
    private static final Object a = new Object();
    @NonNull
    private final ho b;

    public hi(@NonNull Context context, @NonNull String str) {
        this.b = new ho(context, str);
    }

    @Override // com.yandex.mobile.ads.impl.he
    @Nullable
    public final Location a() {
        Location location;
        synchronized (a) {
            location = null;
            hn a3 = this.b.a();
            if (a3 != null && a3.a()) {
                location = a3.b();
                this.b.b();
            }
        }
        return location;
    }
}
