package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zzst implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzss zzbuu;

    public zzst(zzss zzss) {
        this.zzbuu = zzss;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbuu.lock) {
            try {
                if (this.zzbuu.zzbuw != null) {
                    zzss zzss = this.zzbuu;
                    zzss.zzbux = zzss.zzbuw.zzmx();
                }
            } catch (DeadObjectException e) {
                zzbbd.zzc("Unable to obtain a cache service instance.", e);
                this.zzbuu.disconnect();
            }
            this.zzbuu.lock.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbuu.lock) {
            this.zzbuu.zzbux = null;
            this.zzbuu.lock.notifyAll();
        }
    }
}
