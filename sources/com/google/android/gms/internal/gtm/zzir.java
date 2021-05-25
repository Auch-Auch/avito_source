package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
public final class zzir extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        for (zzoa<?> zzoa : ((zzoh) zzoaArr[0]).value()) {
            zzoa<?> zza = zzoo.zza(zzfl, zzoa);
            if ((zza instanceof zzog) && (zza == zzog.zzauj || zza == zzog.zzauk || ((zzog) zza).zzmh())) {
                return zza;
            }
        }
        return zzog.zzaum;
    }
}
