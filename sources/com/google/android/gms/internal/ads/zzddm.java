package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzddm implements zzdek<Bundle> {
    private final String zzguk;

    public zzddm(String str) {
        this.zzguk = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        bundle.putString("rtb", this.zzguk);
    }
}
