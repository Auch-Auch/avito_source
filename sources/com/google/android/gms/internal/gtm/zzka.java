package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
public final class zzka extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        return new zzom(((String) ((zzom) zzoaArr[0]).value()).toUpperCase());
    }
}
