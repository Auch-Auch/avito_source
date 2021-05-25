package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zzaig implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbq zzbvn;

    public zzaig(zzahz zzahz, zzbbq zzbbq) {
        this.zzbvn = zzbbq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbvn.setException(new RuntimeException("Connection failed."));
    }
}
