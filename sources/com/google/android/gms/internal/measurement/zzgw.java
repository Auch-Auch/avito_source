package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
public final class zzgw extends zzhd {
    private final int zzc;
    private final int zzd;

    public zzgw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgt.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhd, com.google.android.gms.internal.measurement.zzgt
    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a.m2(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(a.p2(40, "Index > length: ", i, ", ", zza));
    }

    @Override // com.google.android.gms.internal.measurement.zzhd, com.google.android.gms.internal.measurement.zzgt
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhd, com.google.android.gms.internal.measurement.zzgt
    public final int zza() {
        return this.zzd;
    }
}
