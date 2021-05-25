package com.google.android.gms.measurement.internal;

import android.os.Bundle;
public final class zzhr implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhh zzb;

    public zzhr(zzhh zzhh, Bundle bundle) {
        this.zzb = zzhh;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
