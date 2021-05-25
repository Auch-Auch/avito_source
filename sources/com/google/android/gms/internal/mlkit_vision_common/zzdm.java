package com.google.android.gms.internal.mlkit_vision_common;

import a2.b.a.a.a;
public final class zzdm extends zzdp {
    private final int zzc;
    private final int zzd;

    public zzdm(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdf.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdp, com.google.android.gms.internal.mlkit_vision_common.zzdf
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdp, com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdp
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdp, com.google.android.gms.internal.mlkit_vision_common.zzdf
    public final int zza() {
        return this.zzd;
    }
}
