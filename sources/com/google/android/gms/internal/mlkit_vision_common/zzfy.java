package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public final class zzfy<T> implements zzgh<T> {
    private final zzfr zza;
    private final zzgz<?, ?> zzb;
    private final boolean zzc;
    private final zzea<?> zzd;

    private zzfy(zzgz<?, ?> zzgz, zzea<?> zzea, zzfr zzfr) {
        this.zzb = zzgz;
        this.zzc = zzea.zza(zzfr);
        this.zzd = zzea;
        this.zza = zzfr;
    }

    public static <T> zzfy<T> zza(zzgz<?, ?> zzgz, zzea<?> zzea, zzfr zzfr) {
        return new zzfy<>(zzgz, zzea, zzfr);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final void zzb(T t, T t2) {
        zzgj.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzgj.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final int zzb(T t) {
        zzgz<?, ?> zzgz = this.zzb;
        int zzc2 = zzgz.zzc(zzgz.zza(t)) + 0;
        return this.zzc ? zzc2 + this.zzd.zza((Object) t).zzg() : zzc2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzgh
    public final void zza(T t, zzht zzht) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzed zzed = (zzed) next.getKey();
            if (zzed.zzc() != zzhu.MESSAGE || zzed.zzd() || zzed.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzey) {
                zzht.zza(zzed.zza(), (Object) ((zzey) next).zza().zzc());
            } else {
                zzht.zza(zzed.zza(), next.getValue());
            }
        }
        zzgz<?, ?> zzgz = this.zzb;
        zzgz.zzb((zzgz<?, ?>) zzgz.zza(t), zzht);
    }
}
