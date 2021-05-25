package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
public final class zzbag extends zzaxu {
    private final String url;
    private final zzbbh zzeck;

    public zzbag(Context context, String str, String str2) {
        this(str2, zzp.zzkp().zzs(context, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaxu
    public final void zzuy() {
        this.zzeck.zzes(this.url);
    }

    private zzbag(String str, String str2) {
        this.zzeck = new zzbbh(str2);
        this.url = str;
    }
}
