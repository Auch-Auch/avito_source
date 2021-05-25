package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.Digest;
public class NTRUSignerPrng {
    public int a = 0;
    public byte[] b;
    public Digest c;

    public NTRUSignerPrng(byte[] bArr, Digest digest) {
        this.b = bArr;
        this.c = digest;
    }
}
