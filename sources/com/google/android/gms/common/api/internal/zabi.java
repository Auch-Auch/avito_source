package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
public final class zabi implements Runnable {
    private final /* synthetic */ ConnectionResult zaa;
    private final /* synthetic */ GoogleApiManager.zac zab;

    public zabi(GoogleApiManager.zac zac, ConnectionResult connectionResult) {
        this.zab = zac;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiManager.zaa zaa2 = (GoogleApiManager.zaa) GoogleApiManager.this.zam.get(this.zab.zac);
        if (zaa2 != null) {
            if (this.zaa.isSuccess()) {
                this.zab.zaf = true;
                if (this.zab.zab.requiresSignIn()) {
                    this.zab.zaa();
                    return;
                }
                try {
                    this.zab.zab.getRemoteService(null, this.zab.zab.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException unused) {
                    this.zab.zab.disconnect("Failed to get service from broker.");
                    zaa2.onConnectionFailed(new ConnectionResult(10));
                }
            } else {
                zaa2.onConnectionFailed(this.zaa);
            }
        }
    }
}
