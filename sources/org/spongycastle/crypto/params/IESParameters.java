package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;
public class IESParameters implements CipherParameters {
    public byte[] a;
    public byte[] b;
    public int c;

    public IESParameters(byte[] bArr, byte[] bArr2, int i) {
        this.a = bArr;
        this.b = bArr2;
        this.c = i;
    }

    public byte[] getDerivationV() {
        return this.a;
    }

    public byte[] getEncodingV() {
        return this.b;
    }

    public int getMacKeySize() {
        return this.c;
    }
}
