package com.google.android.gms.internal.ads;

import org.json.JSONObject;
public final class zzcvl implements zzcrf<zzapa, zzcso> {
    private final zzcws zzgoe;

    public zzcvl(zzcws zzcws) {
        this.zzgoe = zzcws;
    }

    @Override // com.google.android.gms.internal.ads.zzcrf
    public final zzcrg<zzapa, zzcso> zzf(String str, JSONObject jSONObject) throws zzdlr {
        zzapa zzgp = this.zzgoe.zzgp(str);
        if (zzgp == null) {
            return null;
        }
        return new zzcrg<>(zzgp, new zzcso(), str);
    }
}
