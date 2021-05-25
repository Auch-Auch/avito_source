package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;
public final class zaah extends zaba {
    private final /* synthetic */ ConnectionResult zaa;
    private final /* synthetic */ zaai zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaah(zaai zaai, zaay zaay, ConnectionResult connectionResult) {
        super(zaay);
        this.zab = zaai;
        this.zaa = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    @GuardedBy("mLock")
    public final void zaa() {
        this.zab.zaa.zab(this.zaa);
    }
}
