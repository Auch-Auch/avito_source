package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdwh<V> extends zzdvf<V> implements RunnableFuture<V> {
    private volatile zzdvs<?> zzhqm;

    private zzdwh(Callable<V> callable) {
        this.zzhqm = new zzdwj(this, callable);
    }

    public static <V> zzdwh<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzdwh<>(Executors.callable(runnable, v));
    }

    public static <V> zzdwh<V> zzf(Callable<V> callable) {
        return new zzdwh<>(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final void afterDone() {
        zzdvs<?> zzdvs;
        super.afterDone();
        if (wasInterrupted() && (zzdvs = this.zzhqm) != null) {
            zzdvs.interruptTask();
        }
        this.zzhqm = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdui
    public final String pendingToString() {
        zzdvs<?> zzdvs = this.zzhqm;
        if (zzdvs == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdvs);
        return a.s2(valueOf.length() + 7, "task=[", valueOf, "]");
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzdvs<?> zzdvs = this.zzhqm;
        if (zzdvs != null) {
            zzdvs.run();
        }
        this.zzhqm = null;
    }

    public zzdwh(zzdut<V> zzdut) {
        this.zzhqm = new zzdwk(this, zzdut);
    }
}
