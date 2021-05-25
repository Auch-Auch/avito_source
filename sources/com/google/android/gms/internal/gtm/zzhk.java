package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzhk extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        List<zzoa<?>> value = ((zzoh) zzoaArr[0]).value();
        return !value.isEmpty() ? value.remove(value.size() - 1) : zzog.zzaum;
    }
}
