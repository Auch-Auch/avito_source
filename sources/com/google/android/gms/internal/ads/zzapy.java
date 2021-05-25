package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
public final class zzapy {
    private final zzbfq zzdgc;
    private final boolean zzdmv;
    private final String zzdmw;

    public zzapy(zzbfq zzbfq, Map<String, String> map) {
        this.zzdgc = zzbfq;
        this.zzdmw = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdmv = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdmv = true;
        }
    }

    public final void execute() {
        int i;
        if (this.zzdgc == null) {
            zzbbd.zzfe("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdmw)) {
            zzp.zzkr();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdmw)) {
            zzp.zzkr();
            i = 6;
        } else if (this.zzdmv) {
            i = -1;
        } else {
            i = zzp.zzkr().zzxs();
        }
        this.zzdgc.setRequestedOrientation(i);
    }
}
