package com.google.android.gms.internal.ads;

import java.io.InputStream;
public final class zztf extends zzbbq<InputStream> {
    private final /* synthetic */ zztg zzbvg;

    public zztf(zztg zztg) {
        this.zzbvg = zztg;
    }

    @Override // com.google.android.gms.internal.ads.zzbbq, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbvg.disconnect();
        return super.cancel(z);
    }
}
