package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxl implements AppEventListener {
    @GuardedBy("this")
    private zzxc zzgqm;

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        zzxc zzxc = this.zzgqm;
        if (zzxc != null) {
            try {
                zzxc.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }

    public final synchronized zzxc zzaqb() {
        return this.zzgqm;
    }

    public final synchronized void zzb(zzxc zzxc) {
        this.zzgqm = zzxc;
    }
}
