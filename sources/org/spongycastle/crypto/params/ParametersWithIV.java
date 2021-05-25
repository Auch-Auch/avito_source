package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class ParametersWithIV implements CipherParameters {
    public byte[] a;
    public CipherParameters b;

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public byte[] getIV() {
        return this.a;
    }

    public CipherParameters getParameters() {
        return this.b;
    }

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        this.b = cipherParameters;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
