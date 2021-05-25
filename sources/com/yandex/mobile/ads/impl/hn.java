package com.yandex.mobile.ads.impl;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class hn {
    @NonNull
    private final Object a;

    public hn(@NonNull Object obj) {
        this.a = obj;
    }

    public final boolean a() {
        Object a3 = Cif.a(this.a, "isComplete", new Object[0]);
        if (a3 instanceof Boolean) {
            return ((Boolean) a3).booleanValue();
        }
        return false;
    }

    @Nullable
    public final Location b() {
        Object a3 = Cif.a(this.a, "getResult", new Object[0]);
        if (a3 instanceof Location) {
            return (Location) a3;
        }
        return null;
    }
}
