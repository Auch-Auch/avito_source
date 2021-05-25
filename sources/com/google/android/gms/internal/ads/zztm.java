package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zztm implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zztg zzbvg;
    private final /* synthetic */ zzbbq zzbvn;

    public zztm(zztg zztg, zzbbq zzbbq) {
        this.zzbvg = zztg;
        this.zzbvn = zzbbq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbvg.lock) {
            this.zzbvn.setException(new RuntimeException("Connection failed."));
        }
    }
}
