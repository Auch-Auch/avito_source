package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxj implements zzut {
    @GuardedBy("this")
    private zzwg zzgql;

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized void onAdClicked() {
        zzwg zzwg = this.zzgql;
        if (zzwg != null) {
            try {
                zzwg.onAdClicked();
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zzb(zzwg zzwg) {
        this.zzgql = zzwg;
    }
}
