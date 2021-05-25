package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxu {
    @Nullable
    @GuardedBy("this")
    private zzyf zzadq;
    @GuardedBy("this")
    private boolean zzaey = false;
    private final String zzbuo;
    private final zzcxy<zzbpd> zzgqv;

    public zzcxu(zzcxy<zzbpd> zzcxy, String str) {
        this.zzgqv = zzcxy;
        this.zzbuo = str;
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            zzyf zzyf = this.zzadq;
            if (zzyf == null) {
                return null;
            }
            return zzyf.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final synchronized boolean isLoading() throws RemoteException {
        return this.zzgqv.isLoading();
    }

    public final synchronized void zza(zzvc zzvc, int i) throws RemoteException {
        this.zzadq = null;
        this.zzaey = this.zzgqv.zza(zzvc, this.zzbuo, new zzcxz(i), new zzcxt(this));
    }

    public final synchronized String zzkf() {
        try {
            zzyf zzyf = this.zzadq;
            if (zzyf == null) {
                return null;
            }
            return zzyf.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
