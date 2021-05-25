package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdel implements zzelo<zzdee> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzfrj;

    private zzdel(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2) {
        this.zzerr = zzelx;
        this.zzfrj = zzelx2;
    }

    public static zzdee zza(zzdvw zzdvw, Context context) {
        return new zzdee(zzdvw, context);
    }

    public static zzdel zzbg(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2) {
        return new zzdel(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzerr.get(), this.zzfrj.get());
    }
}
