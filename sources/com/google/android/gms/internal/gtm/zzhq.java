package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
public final class zzhq extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        int zzc = (int) zzha.zzc(zzoaArr[1]);
        if (zzc < 0) {
            i = Math.max(zzoh.value().size() + zzc, 0);
        } else {
            i = Math.min(zzc, zzoh.value().size());
        }
        int size = zzoh.value().size();
        if (zzoaArr.length == 3) {
            int zzc2 = (int) zzha.zzc(zzoaArr[2]);
            if (zzc2 < 0) {
                size = Math.max(zzoh.value().size() + zzc2, 0);
            } else {
                size = Math.min(zzc2, zzoh.value().size());
            }
        }
        return new zzoh(new ArrayList(zzoh.value().subList(i, Math.max(i, size))));
    }
}
