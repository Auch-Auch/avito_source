package com.google.android.gms.internal.gtm;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
public final class zzgh implements ComponentCallbacks2 {
    public final /* synthetic */ zzfy zzaqb;

    public zzgh(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.zzaqb.zzamv.execute(new zzgi(this));
        }
    }
}
