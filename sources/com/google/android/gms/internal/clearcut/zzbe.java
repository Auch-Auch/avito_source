package com.google.android.gms.internal.clearcut;

import a2.b.a.a.a;
public final class zzbe extends zzbi {
    private final int zzfm;
    private final int zzfn;

    public zzbe(byte[] bArr, int i, int i2) {
        super(bArr);
        zzbb.zzb(i, i + i2, bArr.length);
        this.zzfm = i;
        this.zzfn = i2;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbi, com.google.android.gms.internal.clearcut.zzbb
    public final int size() {
        return this.zzfn;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbi
    public final int zzac() {
        return this.zzfm;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbi, com.google.android.gms.internal.clearcut.zzbb
    public final byte zzj(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzfp[this.zzfm + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(a.m2(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(a.p2(40, "Index > length: ", i, ", ", size));
    }
}
