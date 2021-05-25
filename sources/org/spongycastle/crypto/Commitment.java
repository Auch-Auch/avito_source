package org.spongycastle.crypto;
public class Commitment {
    public final byte[] a;
    public final byte[] b;

    public Commitment(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2;
    }

    public byte[] getCommitment() {
        return this.b;
    }

    public byte[] getSecret() {
        return this.a;
    }
}
