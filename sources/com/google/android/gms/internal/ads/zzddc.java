package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzddc implements zzdek<Bundle> {
    private final Bundle zzfsj;

    public zzddc(Bundle bundle) {
        this.zzfsj = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzfsj;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
