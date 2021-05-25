package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzhp extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        boolean z = true;
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzog zzog = zzog.zzaum;
        List<zzoa<?>> value = ((zzoh) zzoaArr[0]).value();
        return !value.isEmpty() ? value.remove(0) : zzog;
    }
}
