package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
public final class zzhc extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        ArrayList arrayList = new ArrayList();
        for (zzoa<?> zzoa : ((zzoh) zzoaArr[0]).value()) {
            arrayList.add(zzoa);
        }
        for (int i = 1; i < zzoaArr.length; i++) {
            if (zzoaArr[i] instanceof zzoh) {
                for (zzoa<?> zzoa2 : ((zzoh) zzoaArr[i]).value()) {
                    arrayList.add(zzoa2);
                }
            } else {
                arrayList.add(zzoaArr[i]);
            }
        }
        return new zzoh(arrayList);
    }
}
