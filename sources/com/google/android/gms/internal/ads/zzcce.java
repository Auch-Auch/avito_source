package com.google.android.gms.internal.ads;

import org.json.JSONObject;
public final class zzcce implements zzelo<JSONObject> {
    private final zzccc zzfwr;

    public zzcce(zzccc zzccc) {
        this.zzfwr = zzccc;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (JSONObject) zzelu.zza(this.zzfwr.zzalf(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
