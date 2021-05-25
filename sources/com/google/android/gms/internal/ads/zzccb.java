package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;
public final class zzccb implements zzelo<JSONObject> {
    private final zzelx<zzccz> zzeul;
    private final zzccc zzfwr;

    public zzccb(zzccc zzccc, zzelx<zzccz> zzelx) {
        this.zzfwr = zzccc;
        this.zzeul = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzeul.get().zzaly();
    }
}
