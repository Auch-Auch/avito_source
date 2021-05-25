package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzblm implements zzblg {
    private final zzaya zzdza;

    public zzblm(zzaya zzaya) {
        this.zzdza = zzaya;
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final void zzl(Map<String, String> map) {
        String str = map.get("value");
        if ("auto_collect_location".equals(map.get("key"))) {
            this.zzdza.zzaq(Boolean.parseBoolean(str));
        }
    }
}
