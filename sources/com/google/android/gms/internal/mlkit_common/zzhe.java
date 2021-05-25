package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public final class zzhe<T> implements zzhr<T> {
    private final zzhb zza;
    private final zzij<?, ?> zzb;
    private final boolean zzc;
    private final zzfg<?> zzd;

    private zzhe(zzij<?, ?> zzij, zzfg<?> zzfg, zzhb zzhb) {
        this.zzb = zzij;
        this.zzc = zzfg.zza(zzhb);
        this.zzd = zzfg;
        this.zza = zzhb;
    }

    public static <T> zzhe<T> zza(zzij<?, ?> zzij, zzfg<?> zzfg, zzhb zzhb) {
        return new zzhe<>(zzij, zzfg, zzhb);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final void zzb(T t, T t2) {
        zzht.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzht.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final boolean zzc(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final int zzd(T t) {
        zzij<?, ?> zzij = this.zzb;
        int zzc2 = zzij.zzc(zzij.zza(t)) + 0;
        return this.zzc ? zzc2 + this.zzd.zza((Object) t).zzg() : zzc2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final void zzb(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final void zza(T t, zzjd zzjd) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzfn zzfn = (zzfn) next.getKey();
            if (zzfn.zzc() != zzja.MESSAGE || zzfn.zzd() || zzfn.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzge) {
                zzjd.zza(zzfn.zza(), (Object) ((zzge) next).zza().zzc());
            } else {
                zzjd.zza(zzfn.zza(), next.getValue());
            }
        }
        zzij<?, ?> zzij = this.zzb;
        zzij.zzb((zzij<?, ?>) zzij.zza(t), zzjd);
    }
}
