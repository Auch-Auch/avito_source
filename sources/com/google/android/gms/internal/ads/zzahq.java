package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
public final class zzahq implements zzahf<Object> {
    private final zzahp zzdex;

    private zzahq(zzahp zzahp) {
        this.zzdex = zzahp;
    }

    public static void zza(zzbfq zzbfq, zzahp zzahp) {
        zzbfq.zza("/reward", new zzahq(zzahp));
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzaue zzaue = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzaue = new zzaue(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzbbd.zzd("Unable to parse reward amount.", e);
            }
            this.zzdex.zza(zzaue);
        } else if ("video_start".equals(str)) {
            this.zzdex.zzsv();
        } else if ("video_complete".equals(str)) {
            this.zzdex.zzsw();
        }
    }
}
