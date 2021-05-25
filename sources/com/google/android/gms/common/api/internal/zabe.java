package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
public final class zabe implements Runnable {
    private final /* synthetic */ GoogleApiManager.zaa zaa;

    public zabe(GoogleApiManager.zaa zaa2) {
        this.zaa = zaa2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zam();
    }
}
