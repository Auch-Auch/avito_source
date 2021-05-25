package com.google.android.gms.internal.ads;

import org.json.JSONObject;
public final class zzctg implements zzcrf<zzdlx, zzcso> {
    private final zzcji zzggg;

    public zzctg(zzcji zzcji) {
        this.zzggg = zzcji;
    }

    @Override // com.google.android.gms.internal.ads.zzcrf
    public final zzcrg<zzdlx, zzcso> zzf(String str, JSONObject jSONObject) throws zzdlr {
        zzdlx zzd = this.zzggg.zzd(str, jSONObject);
        if (zzd == null) {
            return null;
        }
        return new zzcrg<>(zzd, new zzcso(), str);
    }
}
