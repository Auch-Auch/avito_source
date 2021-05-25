package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbsj implements zzelo<Context> {
    private final zzelx<Context> zzfrj;
    private final zzbsg zzfsm;

    private zzbsj(zzbsg zzbsg, zzelx<Context> zzelx) {
        this.zzfsm = zzbsg;
        this.zzfrj = zzelx;
    }

    public static zzbsj zza(zzbsg zzbsg, zzelx<Context> zzelx) {
        return new zzbsj(zzbsg, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Context) zzelu.zza(this.zzfsm.zzcc(this.zzfrj.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
