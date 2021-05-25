package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
public final class zzedg extends zzedf {
    public zzedg(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzedf
    public final int[] zzb(int[] iArr, int i) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            zzedf.zza(iArr2, this.zzhyn);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }

    @Override // com.google.android.gms.internal.ads.zzedf
    public final int zzbcs() {
        return 12;
    }
}
