package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzanu extends zzamz {
    private final zzaua zzdkp;
    private final Adapter zzdkz;

    public zzanu(Adapter adapter, zzaua zzaua) {
        this.zzdkz = adapter;
        this.zzdkp = zzaua;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdClicked() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzak(ObjectWrapper.wrap(this.zzdkz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdClosed() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzaj(ObjectWrapper.wrap(this.zzdkz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zze(ObjectWrapper.wrap(this.zzdkz), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdLoaded() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzag(ObjectWrapper.wrap(this.zzdkz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdOpened() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzah(ObjectWrapper.wrap(this.zzdkz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onVideoEnd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zza(zzaes zzaes, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zza(zzanb zzanb) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zza(zzaug zzaug) throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zza(ObjectWrapper.wrap(this.zzdkz), new zzaue(zzaug.getType(), zzaug.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzb(zzaue zzaue) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzb(zzuw zzuw) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzc(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzdd(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzdn(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzdo(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzty() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzai(ObjectWrapper.wrap(this.zzdkz));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zztz() throws RemoteException {
        zzaua zzaua = this.zzdkp;
        if (zzaua != null) {
            zzaua.zzam(ObjectWrapper.wrap(this.zzdkz));
        }
    }
}
