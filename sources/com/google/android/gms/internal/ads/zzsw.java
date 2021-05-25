package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zzsw implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzss zzbuu;

    public zzsw(zzss zzss) {
        this.zzbuu = zzss;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbuu.lock) {
            this.zzbuu.zzbux = null;
            if (this.zzbuu.zzbuw != null) {
                this.zzbuu.zzbuw = null;
            }
            this.zzbuu.lock.notifyAll();
        }
    }
}
