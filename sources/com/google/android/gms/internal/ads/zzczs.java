package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzczs implements zzelo<zzczr> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzdvt<String>> zzgsk;

    private zzczs(zzelx<zzdvt<String>> zzelx, zzelx<Executor> zzelx2) {
        this.zzgsk = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzczs zzaw(zzelx<zzdvt<String>> zzelx, zzelx<Executor> zzelx2) {
        return new zzczs(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzczr(this.zzgsk.get(), this.zzerr.get());
    }
}
