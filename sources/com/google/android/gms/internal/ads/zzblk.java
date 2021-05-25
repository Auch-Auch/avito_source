package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
public final class zzblk implements zzblg {
    private final zzdkv zzfld;

    public zzblk(zzdkv zzdkv) {
        this.zzfld = zzdkv;
    }

    @Override // com.google.android.gms.internal.ads.zzblg
    public final void zzl(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfld.zzbn(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
