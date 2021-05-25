package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
public final class zzcik implements zzk {
    private final /* synthetic */ zzcih zzgdk;

    public zzcik(zzcih zzcih) {
        this.zzgdk = zzcih;
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzkl() {
        this.zzgdk.zzgdg.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzkm() {
        this.zzgdk.zzgdg.onResume();
    }
}
