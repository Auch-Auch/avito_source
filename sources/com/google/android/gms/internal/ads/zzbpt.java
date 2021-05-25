package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzbpt {
    private final zzdlj zzeua;
    private final zzdkx zzflh;
    private final String zzfqh;

    public zzbpt(zzdlj zzdlj, zzdkx zzdkx, @Nullable String str) {
        this.zzeua = zzdlj;
        this.zzflh = zzdkx;
        this.zzfqh = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzdlj zzair() {
        return this.zzeua;
    }

    public final zzdkx zzais() {
        return this.zzflh;
    }

    public final String zzait() {
        return this.zzfqh;
    }
}
