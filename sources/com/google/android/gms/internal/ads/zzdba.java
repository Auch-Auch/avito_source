package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdba implements zzdek<Bundle> {
    private final double zzduc;
    private final boolean zzdud;

    public zzdba(double d, boolean z) {
        this.zzduc = d;
        this.zzdud = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdlu.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdlu.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdud);
        zza2.putDouble("battery_level", this.zzduc);
    }
}
