package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
public class KDFParameters implements DerivationParameters {
    public byte[] a;
    public byte[] b;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.b = bArr;
        this.a = bArr2;
    }

    public byte[] getIV() {
        return this.a;
    }

    public byte[] getSharedSecret() {
        return this.b;
    }
}
