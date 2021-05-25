package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzhf extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = (zzoh) zzoaArr[0];
        zzof zzof = (zzof) zzoaArr[1];
        List<zzoa<?>> value = zzoh.value();
        int size = value.size();
        int i = 0;
        while (i < size && i < zzoh.value().size()) {
            if (zzoh.zzad(i)) {
                ((zzgz) zzof.value()).zzb(zzfl, value.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
            }
            i++;
        }
        return zzog.zzaum;
    }
}
