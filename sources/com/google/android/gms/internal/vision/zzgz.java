package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
public final class zzgz extends zzhc {
    private final int zztx;
    private final int zzty;

    public zzgz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzgs.zze(i, i + i2, bArr.length);
        this.zztx = i;
        this.zzty = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgs
    public final int size() {
        return this.zzty;
    }

    @Override // com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgs
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzua, zzfo(), bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgs
    public final byte zzau(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzua[this.zztx + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a.m2(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(a.p2(40, "Index > length: ", i, ", ", size));
    }

    @Override // com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgs
    public final byte zzav(int i) {
        return this.zzua[this.zztx + i];
    }

    @Override // com.google.android.gms.internal.vision.zzhc
    public final int zzfo() {
        return this.zztx;
    }
}
