package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
public final class zzaho implements zzahn {
    private final /* synthetic */ zzbbq zzdew;

    public zzaho(zzahl zzahl, zzbbq zzbbq) {
        this.zzdew = zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void onFailure(@Nullable String str) {
        this.zzdew.setException(new zzalj(str));
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void zzc(JSONObject jSONObject) {
        this.zzdew.set(jSONObject);
    }
}
