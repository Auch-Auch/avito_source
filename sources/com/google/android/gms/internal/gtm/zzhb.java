package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
public abstract class zzhb implements zzgz {
    public abstract zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr);

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzfl != null);
        Preconditions.checkArgument(zzoaArr != null);
        zzoa<?>[] zzoaArr2 = new zzoa[zzoaArr.length];
        for (int i = 0; i < zzoaArr.length; i++) {
            Preconditions.checkArgument(zzoaArr[i] != null);
            zzoa<?> zzoa = zzoaArr[i];
            zzog zzog = zzog.zzauj;
            Preconditions.checkArgument(zzoa != zzog);
            zzoa<?> zzoa2 = zzoaArr[i];
            zzog zzog2 = zzog.zzauk;
            Preconditions.checkArgument(zzoa2 != zzog2);
            zzoaArr2[i] = zzoo.zza(zzfl, zzoaArr[i]);
            Preconditions.checkArgument(zzoaArr2[i] != null);
            Preconditions.checkArgument(zzoaArr2[i] != zzog);
            Preconditions.checkArgument(zzoaArr2[i] != zzog2);
        }
        zzoa<?> zza = zza(zzfl, zzoaArr2);
        if (zza == null) {
            z = false;
        }
        Preconditions.checkState(z);
        return zza;
    }
}
