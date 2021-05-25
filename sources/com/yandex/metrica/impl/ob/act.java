package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public interface act extends acv {
    <T> Future<T> a(Callable<T> callable);

    void a(@NonNull Runnable runnable);

    void a(@NonNull Runnable runnable, long j);

    void a(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

    void b(@NonNull Runnable runnable);
}
