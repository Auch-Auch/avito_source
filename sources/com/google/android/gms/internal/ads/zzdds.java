package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdds implements zzelo<zzddp> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzcwu> zzesi;
    private final zzelx<ScheduledExecutorService> zzflu;
    private final zzelx<String> zzfne;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzcws> zzgog;

    private zzdds(zzelx<zzdvw> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<String> zzelx3, zzelx<zzcwu> zzelx4, zzelx<Context> zzelx5, zzelx<zzdln> zzelx6, zzelx<zzcws> zzelx7) {
        this.zzerr = zzelx;
        this.zzflu = zzelx2;
        this.zzfne = zzelx3;
        this.zzesi = zzelx4;
        this.zzert = zzelx5;
        this.zzfos = zzelx6;
        this.zzgog = zzelx7;
    }

    public static zzdds zzb(zzelx<zzdvw> zzelx, zzelx<ScheduledExecutorService> zzelx2, zzelx<String> zzelx3, zzelx<zzcwu> zzelx4, zzelx<Context> zzelx5, zzelx<zzdln> zzelx6, zzelx<zzcws> zzelx7) {
        return new zzdds(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzddp(this.zzerr.get(), this.zzflu.get(), this.zzfne.get(), this.zzesi.get(), this.zzert.get(), this.zzfos.get(), this.zzgog.get());
    }
}
