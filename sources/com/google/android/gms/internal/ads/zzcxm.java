package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxm implements zzbsu, zzbsz, zzbtm, zzbuj, zzut {
    @GuardedBy("this")
    private zzwl zzgqn;

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized void onAdClicked() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdClicked();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final synchronized void onAdClosed() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdClosed();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void onAdImpression() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdImpression();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final synchronized void onAdLeftApplication() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdLeftApplication();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdLoaded();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final synchronized void onAdOpened() {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdOpened();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzwl zzaqc() {
        return this.zzgqn;
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
    }

    public final synchronized void zzc(zzwl zzwl) {
        this.zzgqn = zzwl;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final synchronized void zzg(zzuw zzuw) {
        zzwl zzwl = this.zzgqn;
        if (zzwl != null) {
            try {
                zzwl.onAdFailedToLoad(zzuw.errorCode);
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
            try {
                this.zzgqn.zzb(zzuw);
            } catch (RemoteException e2) {
                zzbbd.zzd("Remote Exception at onAdFailedToLoadWithAdError.", e2);
            }
        }
    }
}
