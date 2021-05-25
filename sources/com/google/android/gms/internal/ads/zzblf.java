package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzblf implements zzblg {
    private zzaya zzdza;

    public zzblf(zzaya zzaya) {
        this.zzdza = zzaya;
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final void zzl(Map<String, String> map) {
        this.zzdza.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
