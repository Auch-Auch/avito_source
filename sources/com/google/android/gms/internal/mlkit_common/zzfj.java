package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import java.io.IOException;
import java.util.Map;
public final class zzfj extends zzfg<zzfq.zzf> {
    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final boolean zza(zzhb zzhb) {
        return zzhb instanceof zzfq.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final zzfl<zzfq.zzf> zzb(Object obj) {
        zzfq.zzc zzc = (zzfq.zzc) obj;
        if (zzc.zzc.zzc()) {
            zzc.zzc = (zzfl) zzc.zzc.clone();
        }
        return zzc.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final zzfl<zzfq.zzf> zza(Object obj) {
        return ((zzfq.zzc) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final int zza(Map.Entry<?, ?> entry) {
        zzfq.zzf zzf = (zzfq.zzf) entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfg
    public final void zza(zzjd zzjd, Map.Entry<?, ?> entry) throws IOException {
        zzfq.zzf zzf = (zzfq.zzf) entry.getKey();
        throw new NoSuchMethodError();
    }
}
