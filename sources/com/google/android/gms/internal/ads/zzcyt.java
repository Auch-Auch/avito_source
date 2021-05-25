package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
public final class zzcyt implements zzdvi<zzczg> {
    private final /* synthetic */ zzawt zzgrs;
    private final /* synthetic */ zzcyk zzgrt;

    public zzcyt(zzcyk zzcyk, zzawt zzawt) {
        this.zzgrt = zzcyk;
        this.zzgrs = zzawt;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdvi
    public final /* synthetic */ void onSuccess(@Nullable zzczg zzczg) {
        zzczg zzczg2 = zzczg;
        try {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxc)).booleanValue()) {
                if (this.zzgrt.zzbop.zzedr >= ((Integer) zzwe.zzpu().zzd(zzaat.zzcxe)).intValue()) {
                    if (zzczg2 == null) {
                        this.zzgrs.zza(null, null, null);
                        return;
                    } else {
                        this.zzgrs.zza(zzczg2.zzgsb, zzczg2.zzgsc, zzczg2.zzgsd);
                        return;
                    }
                }
            }
            if (zzczg2 == null) {
                this.zzgrs.zzk(null, null);
            } else {
                this.zzgrs.zzk(zzczg2.zzgsb, zzczg2.zzgsc);
            }
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        try {
            zzawt zzawt = this.zzgrs;
            String valueOf = String.valueOf(th.getMessage());
            zzawt.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }
}
