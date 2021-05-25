package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
public final class zzcwg implements zzg {
    private final /* synthetic */ zzdkx zzgnh;
    private final /* synthetic */ zzdlj zzgnv;
    private final /* synthetic */ zzbbq zzgoz;
    private final /* synthetic */ zzcwm zzgpa;
    private final /* synthetic */ zzcwe zzgpb;

    public zzcwg(zzcwe zzcwe, zzbbq zzbbq, zzdlj zzdlj, zzdkx zzdkx, zzcwm zzcwm) {
        this.zzgpb = zzcwe;
        this.zzgoz = zzbbq;
        this.zzgnv = zzdlj;
        this.zzgnh = zzdkx;
        this.zzgpa = zzcwm;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
        this.zzgoz.set(this.zzgpb.zzgoy.zza(this.zzgnv, this.zzgnh, view, this.zzgpa));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzka() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkb() {
    }
}
