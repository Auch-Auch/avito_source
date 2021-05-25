package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
public final class zacd implements Runnable {
    private final /* synthetic */ zacb zaa;

    public zacd(zacb zacb) {
        this.zaa = zacb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zah.zaa(new ConnectionResult(4));
    }
}
