package com.google.android.gms.internal.ads;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
public final class zzahk implements zzahf<zzbfq> {
    private static final Map<String, Integer> zzdeu = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zza zzder;
    private final zzapw zzdes;
    private final zzaqf zzdet;

    public zzahk(zza zza, zzapw zzapw, zzaqf zzaqf) {
        this.zzder = zza;
        this.zzdes = zzapw;
        this.zzdet = zzaqf;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zza zza;
        zzbfq zzbfq2 = zzbfq;
        int intValue = zzdeu.get((String) map.get(AuthSource.SEND_ABUSE)).intValue();
        if (intValue != 5 && intValue != 7 && (zza = this.zzder) != null && !zza.zzjx()) {
            this.zzder.zzbo(null);
        } else if (intValue == 1) {
            this.zzdes.zzg(map);
        } else if (intValue == 3) {
            new zzapx(zzbfq2, map).execute();
        } else if (intValue == 4) {
            new zzapr(zzbfq2, map).execute();
        } else if (intValue == 5) {
            new zzapy(zzbfq2, map).execute();
        } else if (intValue == 6) {
            this.zzdes.zzac(true);
        } else if (intValue != 7) {
            zzbbd.zzfd("Unknown MRAID command called.");
        } else {
            this.zzdet.zzun();
        }
    }
}
