package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
public final class zzly extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        return new zzod(Boolean.valueOf(zzha.zzd(zzoaArr[0]).equals(zzha.zzd(zzoaArr[1]))));
    }
}
