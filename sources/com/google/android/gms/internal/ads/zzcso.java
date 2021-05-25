package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
public final class zzcso extends zzamz implements zzbuc {
    @GuardedBy("this")
    private zzana zzdlu;
    @GuardedBy("this")
    private zzbuf zzgmc;

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdClicked() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdClosed() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdFailedToLoad(i);
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdImpression() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdLeftApplication() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdLoaded() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdLoaded();
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAdOpened() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onVideoEnd() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onVideoPause() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void onVideoPlay() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuc
    public final synchronized void zza(zzbuf zzbuf) {
        this.zzgmc = zzbuf;
    }

    public final synchronized void zzb(zzana zzana) {
        this.zzdlu = zzana;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzc(int i, String str) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzc(i, str);
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.zzf(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzdd(int i) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzdd(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzdn(String str) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzdn(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzdo(String str) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzdo(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzty() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzty();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zztz() throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zztz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zza(zzanb zzanb) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zza(zzanb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzb(zzuw zzuw) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzb(zzuw);
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.zzg(zzuw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zza(zzaes zzaes, String str) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zza(zzaes, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzb(zzaue zzaue) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzb(zzaue);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zza(zzaug zzaug) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zza(zzaug);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzana zzana = this.zzdlu;
        if (zzana != null) {
            zzana.zzb(bundle);
        }
    }
}
