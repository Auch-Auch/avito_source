package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.internal.mlkit_vision_face.zzel;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
public final class zzej implements zzel.zzb {
    public static final Component<?> zza = Component.builder(zzel.zzb.class).add(Dependency.required(zzeh.class)).factory(zzei.zza).build();
    private final zzeh zzb;

    public zzej(zzeh zzeh) {
        this.zzb = zzeh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzel.zzb
    public final void zza(zzbm.zzad zzad) {
        this.zzb.zza((zzbm.zzad) ((zzgd) zzbm.zzad.zza(zzad).zza(zzbm.zzbh.zza(zzad.zza()).zza(true)).zzh()));
    }
}
