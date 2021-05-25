package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
public class acs implements acu {
    @NonNull
    private final Looper a;
    @NonNull
    private final Handler b;
    @NonNull
    private final acw c;

    public acs(@NonNull String str) {
        this(a(str));
    }

    @Override // com.yandex.metrica.impl.ob.acu
    @NonNull
    public Handler a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.acu
    @NonNull
    public Looper b() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.acv
    public boolean c() {
        return this.c.c();
    }

    @VisibleForTesting
    public acs(@NonNull acw acw) {
        this(acw, acw.getLooper(), new Handler(acw.getLooper()));
    }

    @Override // com.yandex.metrica.impl.ob.act
    public void a(@NonNull Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // com.yandex.metrica.impl.ob.act
    public void b(@NonNull Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }

    @VisibleForTesting
    public acs(@NonNull acw acw, @NonNull Looper looper, @NonNull Handler handler) {
        this.c = acw;
        this.a = looper;
        this.b = handler;
    }

    @Override // com.yandex.metrica.impl.ob.act
    public <T> Future<T> a(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        a(futureTask);
        return futureTask;
    }

    @Override // com.yandex.metrica.impl.ob.act
    public void a(@NonNull Runnable runnable, long j) {
        a(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.yandex.metrica.impl.ob.act
    public void a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }

    private static acw a(@NonNull String str) {
        acw a3 = new acy(str).a();
        a3.start();
        return a3;
    }
}
