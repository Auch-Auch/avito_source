package com.google.android.gms.internal.ads;

import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Map;
public final class zzahb implements zzahf<zzbfq> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbfq zzbfq, Map map) {
        zzbfq zzbfq2 = zzbfq;
        String str = (String) map.get("action");
        if (Tracker.Events.CREATIVE_PAUSE.equals(str)) {
            zzbfq2.zzkl();
        } else if (Tracker.Events.CREATIVE_RESUME.equals(str)) {
            zzbfq2.zzkm();
        }
    }
}
