package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzau extends zzag.zzb {
    private final /* synthetic */ zzt zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzau(zzag zzag, zzt zzt) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzt;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zzd.zzm.getGmpAppId(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
