package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public final class zzclg {
    private ConcurrentHashMap<String, String> zzgfd;

    public zzclg(zzcln zzcln) {
        this.zzgfd = zzcln.zzaot();
    }

    public final void zzc(zzdlj zzdlj) {
        if (zzdlj.zzhbq.zzhbm.size() > 0) {
            int i = zzdlj.zzhbq.zzhbm.get(0).zzhag;
            if (i == 1) {
                this.zzgfd.put("ad_format", "banner");
            } else if (i == 2) {
                this.zzgfd.put("ad_format", "interstitial");
            } else if (i == 3) {
                this.zzgfd.put("ad_format", "native_express");
            } else if (i == 4) {
                this.zzgfd.put("ad_format", "native_advanced");
            } else if (i != 5) {
                this.zzgfd.put("ad_format", "unknown");
            } else {
                this.zzgfd.put("ad_format", "rewarded");
            }
        }
        if (!TextUtils.isEmpty(zzdlj.zzhbq.zzhbn.zzdsg)) {
            this.zzgfd.put("gqi", zzdlj.zzhbq.zzhbn.zzdsg);
        }
    }

    public final void zzj(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzgfd.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzgfd.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzrr() {
        return this.zzgfd;
    }
}
