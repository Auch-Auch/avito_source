package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zam;
public final class zacc implements Runnable {
    private final /* synthetic */ zam zaa;
    private final /* synthetic */ zacb zab;

    public zacc(zacb zacb, zam zam) {
        this.zab = zacb;
        this.zaa = zam;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zab(this.zaa);
    }
}
