package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzblh implements zzblg {
    private zzaya zzdza;

    public zzblh(zzaya zzaya) {
        this.zzdza = zzaya;
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final void zzl(Map<String, String> map) {
        this.zzdza.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
