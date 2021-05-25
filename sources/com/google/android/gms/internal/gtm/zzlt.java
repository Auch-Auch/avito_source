package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
public final class zzlt implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzom(a.m2(16, "5.06-", Build.VERSION.SDK_INT));
    }
}
