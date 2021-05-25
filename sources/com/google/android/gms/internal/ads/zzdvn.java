package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
public final class zzdvn<V> implements Runnable {
    private final Future<V> zzhpu;
    private final zzdvi<? super V> zzhpv;

    public zzdvn(Future<V> future, zzdvi<? super V> zzdvi) {
        this.zzhpu = future;
        this.zzhpv = zzdvi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable zza;
        Future<V> future = this.zzhpu;
        if (!(future instanceof zzdwo) || (zza = zzdwn.zza((zzdwo) future)) == null) {
            try {
                this.zzhpv.onSuccess(zzdvl.zza(this.zzhpu));
            } catch (ExecutionException e) {
                this.zzhpv.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzhpv.zzb(e2);
            }
        } else {
            this.zzhpv.zzb(zza);
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        return zzdso.zzx(this).zzy(this.zzhpv).toString();
    }
}
