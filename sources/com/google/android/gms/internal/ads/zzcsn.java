package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public final class zzcsn extends zzaud implements zzbuc {
    @GuardedBy("this")
    private zzaua zzgmb;
    @GuardedBy("this")
    private zzbuf zzgmc;
    @GuardedBy("this")
    private zzbzf zzgmd;

    public final synchronized void zza(zzaua zzaua) {
        this.zzgmb = zzaua;
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzaf(iObjectWrapper);
        }
        zzbzf zzbzf = this.zzgmd;
        if (zzbzf != null) {
            zzbzf.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzag(iObjectWrapper);
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzah(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzam(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zzd(iObjectWrapper, i);
        }
        zzbzf zzbzf = this.zzgmd;
        if (zzbzf != null) {
            zzbzf.zzdx(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zze(iObjectWrapper, i);
        }
        zzbuf zzbuf = this.zzgmc;
        if (zzbuf != null) {
            zzbuf.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuc
    public final synchronized void zza(zzbuf zzbuf) {
        this.zzgmc = zzbuf;
    }

    public final synchronized void zza(zzbzf zzbzf) {
        this.zzgmd = zzbzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzaue zzaue) throws RemoteException {
        zzaua zzaua = this.zzgmb;
        if (zzaua != null) {
            zzaua.zza(iObjectWrapper, zzaue);
        }
    }
}
