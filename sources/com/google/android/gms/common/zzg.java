package com.google.android.gms.common;

import java.util.Arrays;
public final class zzg extends zzd {
    private final byte[] zza;

    public zzg(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        return this.zza;
    }
}
