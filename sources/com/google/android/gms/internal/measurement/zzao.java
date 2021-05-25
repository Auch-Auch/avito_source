package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzao extends zzag.zzb {
    private final /* synthetic */ zzag zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzao(zzag zzag) {
        super(zzag);
        this.zzc = zzag;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zzc.zzm.resetAnalyticsData(this.zza);
    }
}
