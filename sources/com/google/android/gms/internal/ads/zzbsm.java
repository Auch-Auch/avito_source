package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsg;
public final class zzbsm implements zzelo<zzbsg.zza> {
    private final zzbsg zzfsm;

    private zzbsm(zzbsg zzbsg) {
        this.zzfsm = zzbsg;
    }

    public static zzbsm zzl(zzbsg zzbsg) {
        return new zzbsm(zzbsg);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbsg.zza) zzelu.zza(this.zzfsm.zzaje(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
