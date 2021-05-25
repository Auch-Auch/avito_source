package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdaa implements zzdek<Bundle> {
    private final Bundle zzgst;

    private zzdaa(Bundle bundle) {
        this.zzgst = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (!this.zzgst.isEmpty()) {
            bundle2.putBundle("installed_adapter_data", this.zzgst);
        }
    }
}
