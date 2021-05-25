package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
public final class zzces implements zzbtm {
    private final zzccv zzfvt;
    private final zzccz zzfwz;

    public zzces(zzccv zzccv, zzccz zzccz) {
        this.zzfvt = zzccv;
        this.zzfwz = zzccz;
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void onAdImpression() {
        if (this.zzfvt.zzalu() != null) {
            zzbfq zzalt = this.zzfvt.zzalt();
            zzbfq zzals = this.zzfvt.zzals();
            if (zzalt == null) {
                zzalt = zzals != null ? zzals : null;
            }
            if (this.zzfwz.zzalj() && zzalt != null) {
                zzalt.zza("onSdkImpression", new ArrayMap());
            }
        }
    }
}
