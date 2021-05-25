package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
public final class zzcwq implements zzg {
    private final /* synthetic */ zzbzt zzgph;

    public zzcwq(zzcwl zzcwl, zzbzt zzbzt) {
        this.zzgph = zzbzt;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzka() {
        this.zzgph.zzaeo().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkb() {
        this.zzgph.zzaep().onAdImpression();
        this.zzgph.zzaeq().zzaki();
    }
}
