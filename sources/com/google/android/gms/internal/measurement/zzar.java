package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzar extends zzag.zzb {
    private final /* synthetic */ long zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzar(zzag zzag, long j) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zzd.zzm.setMinimumSessionDuration(this.zzc);
    }
}
