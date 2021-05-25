package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzbc extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzt zzd;
    private final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbc(zzag zzag, String str, zzt zzt) {
        super(zzag);
        this.zze = zzag;
        this.zzc = str;
        this.zzd = zzt;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zze.zzm.getMaxUserProperties(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
