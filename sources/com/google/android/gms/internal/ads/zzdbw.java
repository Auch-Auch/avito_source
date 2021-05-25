package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdbw implements zzelo<zzdbs> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzfrj;

    private zzdbw(zzelx<Context> zzelx, zzelx<zzdvw> zzelx2) {
        this.zzfrj = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzdbs zza(Context context, zzdvw zzdvw) {
        return new zzdbs(context, zzdvw);
    }

    public static zzdbw zzba(zzelx<Context> zzelx, zzelx<zzdvw> zzelx2) {
        return new zzdbw(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfrj.get(), this.zzerr.get());
    }
}
