package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
public final class zzdeu implements zzdek<Bundle> {
    private final String zzdtm;
    private final int zzdtx;
    private final int zzdty;
    private final int zzdtz;
    private final boolean zzdue;
    private final int zzduf;

    public zzdeu(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdtm = str;
        this.zzdtx = i;
        this.zzdty = i2;
        this.zzdtz = i3;
        this.zzdue = z;
        this.zzduf = i4;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.zzdtm;
        boolean z = true;
        zzdlu.zza(bundle2, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzdtx);
        if (this.zzdtx == -2) {
            z = false;
        }
        zzdlu.zza(bundle2, "cnt", valueOf, z);
        bundle2.putInt("gnt", this.zzdty);
        bundle2.putInt("pt", this.zzdtz);
        Bundle zza = zzdlu.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdlu.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzduf);
        zza2.putBoolean("active_network_metered", this.zzdue);
    }
}
