package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;
public final class zzbn extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ Bundle zzd;
    private final /* synthetic */ zzag.zzc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbn(zzag.zzc zzc2, Activity activity, Bundle bundle) {
        super(zzag.this);
        this.zze = zzc2;
        this.zzc = activity;
        this.zzd = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        zzag.this.zzm.onActivityCreated(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
