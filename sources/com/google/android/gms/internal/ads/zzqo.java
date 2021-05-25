package com.google.android.gms.internal.ads;

import org.json.JSONObject;
public final class zzqo {
    private final String zzbqx;
    private final JSONObject zzbqy;
    private final String zzbqz;
    private final String zzbra;
    private final boolean zzbrb = false;
    private final boolean zzbrc;

    public zzqo(String str, zzbbg zzbbg, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbra = zzbbg.zzbra;
        this.zzbqy = jSONObject;
        this.zzbqz = str;
        this.zzbqx = str2;
        this.zzbrc = z2;
    }

    public final String getUniqueId() {
        return this.zzbqz;
    }

    public final boolean isNative() {
        return this.zzbrc;
    }

    public final String zzlr() {
        return this.zzbqx;
    }

    public final String zzls() {
        return this.zzbra;
    }

    public final JSONObject zzlt() {
        return this.zzbqy;
    }
}
