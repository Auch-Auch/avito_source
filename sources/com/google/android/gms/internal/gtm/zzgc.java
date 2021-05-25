package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.os.Bundle;
import com.google.android.gms.tagmanager.zzch;
public final class zzgc extends zzch {
    public final /* synthetic */ zzfy zzaqb;

    public zzgc(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    @Override // com.google.android.gms.tagmanager.zzcg
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (!str.endsWith("+gtm")) {
            this.zzaqb.zzamv.execute(new zzgd(this, str2, bundle, a.r2(str.length() + 4, str, "+gtm"), j, str));
        }
    }
}
