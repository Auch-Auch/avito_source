package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
public final class zzbh extends zzag.zzb {
    private final /* synthetic */ zzt zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbh(zzag zzag, zzt zzt, int i) {
        super(zzag);
        this.zze = zzag;
        this.zzc = zzt;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        this.zze.zzm.getTestFlag(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
