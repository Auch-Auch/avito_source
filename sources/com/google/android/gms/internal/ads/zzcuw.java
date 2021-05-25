package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
public final class zzcuw implements zzcrf<zzdlx, zzcsn> {
    private final zzcji zzggg;
    @GuardedBy("this")
    private final Map<String, zzcrg<zzdlx, zzcsn>> zzgnr = new HashMap();

    public zzcuw(zzcji zzcji) {
        this.zzggg = zzcji;
    }

    @Override // com.google.android.gms.internal.ads.zzcrf
    public final zzcrg<zzdlx, zzcsn> zzf(String str, JSONObject jSONObject) throws zzdlr {
        synchronized (this) {
            zzcrg<zzdlx, zzcsn> zzcrg = this.zzgnr.get(str);
            if (zzcrg == null) {
                zzdlx zzd = this.zzggg.zzd(str, jSONObject);
                if (zzd == null) {
                    return null;
                }
                zzcrg = new zzcrg<>(zzd, new zzcsn(), str);
                this.zzgnr.put(str, zzcrg);
            }
            return zzcrg;
        }
    }
}
