package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzdcl implements zzdek<Bundle> {
    private final zzdkv zzfld;

    public zzdcl(zzdkv zzdkv) {
        this.zzfld = zzdkv;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdkv zzdkv = this.zzfld;
        if (zzdkv != null) {
            bundle2.putBoolean("render_in_browser", zzdkv.zzask());
            bundle2.putBoolean("disable_ml", this.zzfld.zzasl());
        }
    }
}
