package com.google.android.gms.internal.ads;

import android.text.TextUtils;
public final class zzny {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbgy;
    public final String zzbgz;
    public final boolean zzbha;
    public final boolean zzbhb;
    public final int zzbhc;
    public final int zzbhd;
    public final int zzbhe;
    public final boolean zzbhf;
    public final boolean zzbhg;
    public final boolean zzbhh;

    public zzny() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzny.class == obj.getClass()) {
            zzny zzny = (zzny) obj;
            if (this.zzbhb == zzny.zzbhb && this.zzbhc == zzny.zzbhc && this.zzbhd == zzny.zzbhd && this.zzbhf == zzny.zzbhf && this.zzbhg == zzny.zzbhg && this.zzbhh == zzny.zzbhh && this.viewportWidth == zzny.viewportWidth && this.viewportHeight == zzny.viewportHeight && this.zzbhe == zzny.zzbhe && TextUtils.equals(null, null) && TextUtils.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    private zzny(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbgy = null;
        this.zzbgz = null;
        this.zzbha = false;
        this.zzbhb = true;
        this.zzbhc = Integer.MAX_VALUE;
        this.zzbhd = Integer.MAX_VALUE;
        this.zzbhe = Integer.MAX_VALUE;
        this.zzbhf = true;
        this.zzbhg = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbhh = true;
    }
}
