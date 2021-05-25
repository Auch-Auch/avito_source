package com.google.android.gms.internal.ads;

import org.json.JSONObject;
public final class zzcde implements zzelo<zzcdc> {
    private final zzelx<JSONObject> zzeuj;
    private final zzelx<zzdkx> zzfnc;

    public zzcde(zzelx<zzdkx> zzelx, zzelx<JSONObject> zzelx2) {
        this.zzfnc = zzelx;
        this.zzeuj = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcdc(this.zzfnc.get(), this.zzeuj.get());
    }
}
