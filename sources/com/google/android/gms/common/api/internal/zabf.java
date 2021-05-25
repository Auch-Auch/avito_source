package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;
public final class zabf implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ GoogleApiManager.zaa zaa;

    public zabf(GoogleApiManager.zaa zaa2) {
        this.zaa = zaa2;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        GoogleApiManager.this.zaq.post(new zabh(this));
    }
}
