package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
public final class zzdnl {
    private HashMap<zzdng, zzdno<? extends zzbpd>> zzhfl = new HashMap<>();

    public final <AdT extends zzbpd> zzdno<AdT> zza(zzdng zzdng, Context context, zzdmt zzdmt, zzdnw<AdT> zzdnw) {
        zzdno<AdT> zzdno = (zzdno<AdT>) this.zzhfl.get(zzdng);
        if (zzdno != null) {
            return zzdno;
        }
        zzdmz zzdmz = new zzdmz(zzdnd.zza(zzdng, context));
        zzdno<AdT> zzdno2 = new zzdno<>(zzdmz, new zzdnp(zzdmz, zzdmt, zzdnw));
        this.zzhfl.put(zzdng, zzdno2);
        return zzdno2;
    }
}
