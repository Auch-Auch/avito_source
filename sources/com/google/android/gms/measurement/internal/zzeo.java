package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
public final class zzeo<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzem<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    @GuardedBy("overrideLock")
    private volatile V zzg;
    @GuardedBy("cachingLock")
    private volatile V zzh;

    private zzeo(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzem<V> zzem) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzem;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(@Nullable V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzep.zza == null) {
            return this.zzc;
        }
        synchronized (zzf) {
            if (zzx.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
        }
        try {
            for (zzeo zzeo : zzaq.zzct) {
                if (!zzx.zza()) {
                    V v2 = null;
                    try {
                        zzem<V> zzem = zzeo.zzb;
                        if (zzem != null) {
                            v2 = zzem.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzeo.zzh = v2;
                    }
                } else {
                    throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                }
            }
        } catch (SecurityException unused2) {
        }
        zzem<V> zzem2 = this.zzb;
        if (zzem2 == null) {
            return this.zzc;
        }
        try {
            return zzem2.zza();
        } catch (SecurityException unused3) {
            return this.zzc;
        } catch (IllegalStateException unused4) {
            return this.zzc;
        }
    }
}
