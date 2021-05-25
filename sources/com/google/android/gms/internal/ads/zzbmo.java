package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
public final class zzbmo implements zzelo<JSONObject> {
    private final zzelx<zzdkx> zzfnc;

    private zzbmo(zzelx<zzdkx> zzelx) {
        this.zzfnc = zzelx;
    }

    public static zzbmo zzc(zzelx<zzdkx> zzelx) {
        return new zzbmo(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return zzbml.zzb(this.zzfnc.get());
    }
}
