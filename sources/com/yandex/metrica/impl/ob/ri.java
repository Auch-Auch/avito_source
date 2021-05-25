package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class ri {
    @Nullable
    private final LocationManager a;
    @NonNull
    private final dn b;
    @NonNull
    private final zk c = as.a().l();

    public ri(@NonNull Context context) {
        this.a = (LocationManager) context.getSystemService("location");
        this.b = dn.a(context);
    }

    @Nullable
    public LocationManager a() {
        return this.a;
    }

    @NonNull
    public dn b() {
        return this.b;
    }

    @NonNull
    public zk c() {
        return this.c;
    }
}
