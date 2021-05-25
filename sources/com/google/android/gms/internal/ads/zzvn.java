package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
public final class zzvn extends zzxf {
    private final AppEventListener zzbnw;

    public zzvn(AppEventListener appEventListener) {
        this.zzbnw = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnw;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void onAppEvent(String str, String str2) {
        this.zzbnw.onAppEvent(str, str2);
    }
}
