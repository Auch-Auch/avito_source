package org.spongycastle.crypto.params;
public class IESWithCipherParameters extends IESParameters {
    public int d;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i, int i2) {
        super(bArr, bArr2, i);
        this.d = i2;
    }

    public int getCipherKeySize() {
        return this.d;
    }
}
