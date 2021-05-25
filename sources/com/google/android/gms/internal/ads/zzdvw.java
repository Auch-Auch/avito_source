package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
public interface zzdvw extends ExecutorService {
    <T> zzdvt<T> zze(Callable<T> callable);

    zzdvt<?> zzf(Runnable runnable);
}
