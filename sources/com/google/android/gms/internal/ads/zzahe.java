package com.google.android.gms.internal.ads;

import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Map;
public final class zzahe implements zzahf<zzbfq> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zzbfq zzbfq2 = zzbfq;
        if (map.keySet().contains(Tracker.Events.CREATIVE_START)) {
            zzbfq2.zzabe().zzace();
        } else if (map.keySet().contains("stop")) {
            zzbfq2.zzabe().zzacf();
        } else if (map.keySet().contains("cancel")) {
            zzbfq2.zzabe().zzacg();
        }
    }
}
