package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zzaid implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbbq zzbvn;
    private final /* synthetic */ zzahz zzdfd;

    public zzaid(zzahz zzahz, zzbbq zzbbq) {
        this.zzdfd = zzahz;
        this.zzbvn = zzbbq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zzbvn.set(zzahz.zzb(this.zzdfd).zzsx());
        } catch (DeadObjectException e) {
            this.zzbvn.setException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zzbvn.setException(new RuntimeException(a.m2(34, "onConnectionSuspended: ", i)));
    }
}
