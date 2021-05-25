package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcq;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
public final class zzco implements zzcq.zzb {
    public static final Component<?> zza = Component.builder(zzcq.zzb.class).add(Dependency.required(zzcm.class)).factory(zzcn.zza).build();
    private final zzcm zzb;

    public zzco(zzcm zzcm) {
        this.zzb = zzcm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzcq.zzb
    public final void zza(zzr.zzad zzad) {
        this.zzb.zza((zzr.zzad) ((zzej) zzr.zzad.zza(zzad).zza(zzr.zzbh.zza(zzad.zza()).zza(true)).zzh()));
    }
}
