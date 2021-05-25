package org.spongycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;
public class NullDigest implements Digest {
    public ByteArrayOutputStream a = new ByteArrayOutputStream();

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        byte[] byteArray = this.a.toByteArray();
        System.arraycopy(byteArray, 0, bArr, i, byteArray.length);
        reset();
        return byteArray.length;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "NULL";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return this.a.size();
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.a.reset();
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b) {
        this.a.write(b);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }
}
