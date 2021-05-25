package com.google.android.gms.measurement.internal;

import android.os.Bundle;
public final class zzhq implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhh zzb;

    public zzhq(zzhh zzhh, Bundle bundle) {
        this.zzb = zzhh;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
