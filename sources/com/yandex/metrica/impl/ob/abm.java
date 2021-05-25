package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
import java.util.concurrent.Callable;
public abstract class abm<T> implements Callable<T> {
    public abstract T b() throws Exception;

    @Override // java.util.concurrent.Callable
    @Nullable
    public T call() {
        try {
            return b();
        } catch (Throwable unused) {
            return null;
        }
    }
}
