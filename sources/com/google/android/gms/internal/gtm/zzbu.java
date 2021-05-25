package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
public final class zzbu extends zzan {
    @VisibleForTesting
    public zzbu(zzap zzap) {
        super(zzap);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
    }

    public final zzv zzfa() {
        zzdb();
        return zzcq().zzau();
    }

    public final String zzfb() {
        zzdb();
        zzv zzfa = zzfa();
        int i = zzfa.zzul;
        int i2 = zzfa.zzum;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }
}
