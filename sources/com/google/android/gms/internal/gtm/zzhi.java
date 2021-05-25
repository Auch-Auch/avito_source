package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzhi extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        zzoa<?> zzoa = zzoaArr.length < 2 ? zzog.zzaum : zzoaArr[1];
        List<zzoa<?>> value = zzoh.value();
        int size = value.size();
        int i = size - 1;
        if (zzoaArr.length == 3) {
            int zzc = (int) zzha.zzc(zzoaArr[2]);
            if (zzc < 0) {
                i = size - Math.abs(zzc);
            } else {
                i = Math.min(zzc, i);
            }
        }
        while (true) {
            if (i >= 0) {
                if (zzoh.zzad(i) && zzha.zzd(zzoa, value.get(i))) {
                    break;
                }
                i--;
            } else {
                i = -1;
                break;
            }
        }
        return new zzoe(Double.valueOf((double) i));
    }
}
