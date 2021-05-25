package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import java.io.IOException;
import java.util.Map;
public final class zzdz extends zzea<zzej.zzd> {
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final boolean zza(zzfr zzfr) {
        return zzfr instanceof zzej.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final zzeb<zzej.zzd> zzb(Object obj) {
        zzej.zze zze = (zzej.zze) obj;
        if (zze.zzc.zzc()) {
            zze.zzc = (zzeb) zze.zzc.clone();
        }
        return zze.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final zzeb<zzej.zzd> zza(Object obj) {
        return ((zzej.zze) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final int zza(Map.Entry<?, ?> entry) {
        zzej.zzd zzd = (zzej.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzea
    public final void zza(zzht zzht, Map.Entry<?, ?> entry) throws IOException {
        zzej.zzd zzd = (zzej.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }
}
