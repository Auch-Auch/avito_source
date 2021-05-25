package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
public final class zabg implements Runnable {
    private final /* synthetic */ ConnectionResult zaa;
    private final /* synthetic */ GoogleApiManager.zaa zab;

    public zabg(GoogleApiManager.zaa zaa2, ConnectionResult connectionResult) {
        this.zab = zaa2;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.onConnectionFailed(this.zaa);
    }
}
