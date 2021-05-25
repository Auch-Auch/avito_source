package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tagmanager.zzck;
public final class zzga extends zzck {
    public final /* synthetic */ zzfy zzaqb;

    public zzga(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    @Override // com.google.android.gms.tagmanager.zzcj
    public final void interceptEvent(String str, String str2, Bundle bundle, long j) throws RemoteException {
        this.zzaqb.zzamv.execute(new zzgb(this, str2, bundle, a.r2(a.q0(str, 4), str, "+gtm"), j, str));
    }
}
