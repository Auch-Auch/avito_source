package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
public class MGFParameters implements DerivationParameters {
    public byte[] a;

    public MGFParameters(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public byte[] getSeed() {
        return this.a;
    }

    public MGFParameters(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
