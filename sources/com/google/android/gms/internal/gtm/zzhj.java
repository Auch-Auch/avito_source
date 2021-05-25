package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
public final class zzhj extends zzhb {
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
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size && i < zzoh.value().size()) {
            zzoa<?> zzoa = null;
            if (zzoh.zzad(i)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, value.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
                Preconditions.checkState(!zzoo.zzm(zzoa));
            }
            arrayList.add(zzoa);
            i++;
        }
        return new zzoh(arrayList);
    }
}
