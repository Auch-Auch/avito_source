package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdbx implements zzdek<Bundle> {
    private final String zzdrm;
    private final String zzgtv;
    private final Bundle zzgtw;

    private zzdbx(String str, String str2, Bundle bundle) {
        this.zzdrm = str;
        this.zzgtv = str2;
        this.zzgtw = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdrm);
        bundle2.putString("fc_consent", this.zzgtv);
        bundle2.putBundle("iab_consent_info", this.zzgtw);
    }
}
