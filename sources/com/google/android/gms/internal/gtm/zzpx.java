package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
public final class zzpx extends zzqc {
    private final int zzawb;
    private final int zzawc;

    public zzpx(byte[] bArr, int i, int i2) {
        super(bArr);
        zzps.zzb(i, i + i2, bArr.length);
        this.zzawb = i;
        this.zzawc = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final int size() {
        return this.zzawc;
    }

    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final byte zzak(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzawe[this.zzawb + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a.m2(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(a.p2(40, "Index > length: ", i, ", ", size));
    }

    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final byte zzal(int i) {
        return this.zzawe[this.zzawb + i];
    }

    @Override // com.google.android.gms.internal.gtm.zzqc
    public final int zznf() {
        return this.zzawb;
    }
}
