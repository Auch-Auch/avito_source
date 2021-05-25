package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;
public final class zaav extends zabl {
    private WeakReference<zaap> zaa;

    public zaav(zaap zaap) {
        this.zaa = new WeakReference<>(zaap);
    }

    @Override // com.google.android.gms.common.api.internal.zabl
    public final void zaa() {
        zaap zaap = this.zaa.get();
        if (zaap != null) {
            zaap.zae();
        }
    }
}
