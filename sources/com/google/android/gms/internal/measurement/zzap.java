package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzap extends zzag.zzb {
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(zzag zzag, boolean z) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zzd.zzm.setMeasurementEnabled(this.zzc, this.zza);
    }
}
