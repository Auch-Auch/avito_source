package com.google.android.gms.internal.mlkit_vision_face;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public final class zzhs<T> implements zzib<T> {
    private final zzhl zza;
    private final zzit<?, ?> zzb;
    private final boolean zzc;
    private final zzfu<?> zzd;

    private zzhs(zzit<?, ?> zzit, zzfu<?> zzfu, zzhl zzhl) {
        this.zzb = zzit;
        this.zzc = zzfu.zza(zzhl);
        this.zzd = zzfu;
        this.zza = zzhl;
    }

    public static <T> zzhs<T> zza(zzit<?, ?> zzit, zzfu<?> zzfu, zzhl zzhl) {
        return new zzhs<>(zzit, zzfu, zzhl);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final void zzb(T t, T t2) {
        zzid.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzid.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final void zzc(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final int zzb(T t) {
        zzit<?, ?> zzit = this.zzb;
        int zzc2 = zzit.zzc(zzit.zza(t)) + 0;
        return this.zzc ? zzc2 + this.zzd.zza((Object) t).zzg() : zzc2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzib
    public final void zza(T t, zzjn zzjn) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzfx zzfx = (zzfx) next.getKey();
            if (zzfx.zzc() != zzjo.MESSAGE || zzfx.zzd() || zzfx.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzgs) {
                zzjn.zza(zzfx.zza(), (Object) ((zzgs) next).zza().zzc());
            } else {
                zzjn.zza(zzfx.zza(), next.getValue());
            }
        }
        zzit<?, ?> zzit = this.zzb;
        zzit.zzb((zzit<?, ?>) zzit.zza(t), zzjn);
    }
}
