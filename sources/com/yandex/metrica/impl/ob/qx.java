package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;
public abstract class qx {
    public static final long a = TimeUnit.SECONDS.toMillis(1);
    @NonNull
    public final Context b;
    @NonNull
    public final sp c;
    @NonNull
    public final LocationListener d;
    @NonNull
    public final Looper e;

    public qx(@NonNull Context context, @NonNull LocationListener locationListener, @NonNull sp spVar, @NonNull Looper looper) {
        this.b = context;
        this.d = locationListener;
        this.c = spVar;
        this.e = looper;
    }

    public abstract boolean a();

    public abstract void b();

    public abstract void c();
}
