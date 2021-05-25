package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdaw implements zzdek<Bundle> {
    private final float zzdqm;
    private final int zzdtj;
    private final boolean zzdtr;
    private final boolean zzdts;
    private final int zzdtw;
    private final int zzdua;
    private final int zzdub;
    private final boolean zzgth;

    public zzdaw(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdtj = i;
        this.zzdtr = z;
        this.zzdts = z2;
        this.zzdtw = i2;
        this.zzdua = i3;
        this.zzdub = i4;
        this.zzdqm = f;
        this.zzgth = z3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.zzdtj);
        bundle2.putBoolean("ma", this.zzdtr);
        bundle2.putBoolean("sp", this.zzdts);
        bundle2.putInt("muv", this.zzdtw);
        bundle2.putInt("rm", this.zzdua);
        bundle2.putInt("riv", this.zzdub);
        bundle2.putFloat("android_app_volume", this.zzdqm);
        bundle2.putBoolean("android_app_muted", this.zzgth);
    }
}
