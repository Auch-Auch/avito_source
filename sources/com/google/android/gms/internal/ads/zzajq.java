package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
public final class zzajq {
    private final zzajt zzdfv;

    private zzajq(zzajt zzajt) {
        this.zzdfv = zzajt;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.zzdfv.zzdg(str);
    }
}
