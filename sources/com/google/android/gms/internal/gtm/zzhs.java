package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
public final class zzhs extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzof zzof;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        if (zzoaArr.length == 2) {
            Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
            zzof = (zzof) zzoaArr[1];
        } else {
            zzof = new zzof(new zzhv());
        }
        Collections.sort(zzoh.value(), new zzhu(this, zzof, zzfl));
        return zzoaArr[0];
    }
}
