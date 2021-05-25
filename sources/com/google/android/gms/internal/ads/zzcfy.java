package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
public final class zzcfy {
    public final int type = 2;
    public final String zzcn;
    public final String zzgbw;
    public final zzadi zzgbx;

    @VisibleForTesting
    public zzcfy(String str, String str2) {
        this.zzcn = str;
        this.zzgbw = str2;
        this.zzgbx = null;
    }

    @VisibleForTesting
    public zzcfy(String str, zzadi zzadi) {
        this.zzcn = str;
        this.zzgbw = null;
        this.zzgbx = zzadi;
    }
}
