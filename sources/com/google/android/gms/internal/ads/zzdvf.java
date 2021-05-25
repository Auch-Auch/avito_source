package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdui;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class zzdvf<V> extends zzdvc<V> implements zzdui.zzg<V> {
    @Override // com.google.android.gms.internal.ads.zzdui, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) super.get(j, timeUnit);
    }
}
