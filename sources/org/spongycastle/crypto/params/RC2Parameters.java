package org.spongycastle.crypto.params;
public class RC2Parameters extends KeyParameter {
    public int b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RC2Parameters(byte[] bArr) {
        this(bArr, bArr.length > 128 ? 1024 : bArr.length * 8);
    }

    public int getEffectiveKeyBits() {
        return this.b;
    }

    public RC2Parameters(byte[] bArr, int i) {
        super(bArr);
        this.b = i;
    }
}
