package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
public final class zzso extends AppOpenAd {
    private final zzsd zzbur;

    public zzso(zzsd zzsd) {
        this.zzbur = zzsd;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void zza(zzsj zzsj) {
        try {
            this.zzbur.zza(zzsj);
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final zzwu zzdu() {
        try {
            return this.zzbur.zzdu();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return null;
        }
    }
}
