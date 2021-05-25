package com.google.android.gms.internal.ads;
public final class zzcit implements zzaqf {
    private final /* synthetic */ zzcij zzgdm;

    public zzcit(zzcij zzcij) {
        this.zzgdm = zzcij;
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void zza(int i, int i2, int i3, int i4) {
        this.zzgdm.zzfqj.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void zzum() {
        this.zzgdm.zzfqj.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final void zzun() {
        this.zzgdm.zzgdj.zzaia();
    }
}
