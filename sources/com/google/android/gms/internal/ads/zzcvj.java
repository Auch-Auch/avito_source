package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
public final class zzcvj extends zzaud {
    private final /* synthetic */ zzbur zzgny;
    private final /* synthetic */ zzbst zzgnz;
    private final /* synthetic */ zzbtu zzgoa;
    private final /* synthetic */ zzbzc zzgob;

    public zzcvj(zzcvf zzcvf, zzbur zzbur, zzbst zzbst, zzbtu zzbtu, zzbzc zzbzc) {
        this.zzgny = zzbur;
        this.zzgnz = zzbst;
        this.zzgoa = zzbtu;
        this.zzgob = zzbzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zza(IObjectWrapper iObjectWrapper, zzaue zzaue) {
        this.zzgob.zza(zzaue);
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgny.zzuj();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgob.zzsv();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgny.zzui();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgnz.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgoa.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzgoa.onRewardedVideoCompleted();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
