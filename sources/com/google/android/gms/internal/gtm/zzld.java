package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
public final class zzld implements zzgz {
    private final String zzarr = Build.MANUFACTURER;
    private final String zzars = Build.MODEL;

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = false;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length == 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        String str = this.zzarr;
        String str2 = this.zzars;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = a.s2(str2.length() + str.length() + 1, str, " ", str2);
        }
        return new zzom(str2);
    }
}
