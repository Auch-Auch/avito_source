package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;
public final class zzbm extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzag.zzc zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbm(zzag.zzc zzc2, Activity activity) {
        super(zzag.this);
        this.zzd = zzc2;
        this.zzc = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        zzag.this.zzm.onActivityStarted(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
