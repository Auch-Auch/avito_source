package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
public final class zzhw extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length >= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        int zzc = (int) zzha.zzc(zzoaArr[1]);
        if (zzc < 0) {
            i = Math.max(zzoh.value().size() + zzc, 0);
        } else {
            i = Math.min(zzc, zzoh.value().size());
        }
        int min = Math.min(Math.max((int) zzha.zzc(zzoaArr[2]), 0), zzoh.value().size() - i) + i;
        ArrayList arrayList = new ArrayList(zzoh.value().subList(i, min));
        zzoh.value().subList(i, min).clear();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 3; i2 < zzoaArr.length; i2++) {
            arrayList2.add(zzoaArr[i2]);
        }
        zzoh.value().addAll(i, arrayList2);
        return new zzoh(arrayList);
    }
}
