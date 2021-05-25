package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import java.io.IOException;
import java.util.Map;
public final class zzft extends zzfu<zzgd.zzd> {
    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final boolean zza(zzhl zzhl) {
        return zzhl instanceof zzgd.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final zzfv<zzgd.zzd> zzb(Object obj) {
        zzgd.zze zze = (zzgd.zze) obj;
        if (zze.zzc.zzc()) {
            zze.zzc = (zzfv) zze.zzc.clone();
        }
        return zze.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final zzfv<zzgd.zzd> zza(Object obj) {
        return ((zzgd.zze) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final int zza(Map.Entry<?, ?> entry) {
        zzgd.zzd zzd = (zzgd.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzfu
    public final void zza(zzjn zzjn, Map.Entry<?, ?> entry) throws IOException {
        zzgd.zzd zzd = (zzgd.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }
}
