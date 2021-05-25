package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
public final class zzjg extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        List<zzoa<?>> value = ((zzoh) zzoaArr[1]).value();
        List<zzoa<?>> value2 = ((zzoh) zzoaArr[2]).value();
        Preconditions.checkArgument(value2.size() <= value.size() + 1);
        boolean z = false;
        for (int i = 0; i < value.size(); i++) {
            if (z || zzha.zzd(zzoa, zzoo.zza(zzfl, value.get(i)))) {
                zzoa<?> zza = zzoo.zza(zzfl, value2.get(i));
                if (!(zza instanceof zzog)) {
                    z = true;
                } else if (zza == zzog.zzauk || ((zzog) zza).zzmh()) {
                    return zza;
                } else {
                    if (zza == zzog.zzauj) {
                        return zzog.zzaum;
                    }
                }
            }
        }
        if (value.size() < value2.size()) {
            zzoa<?> zza2 = zzoo.zza(zzfl, (zzoa) a.j2(value2, 1));
            if ((zza2 instanceof zzog) && (zza2 == zzog.zzauk || ((zzog) zza2).zzmh())) {
                return zza2;
            }
        }
        return zzog.zzaum;
    }
}
