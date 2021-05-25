package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
public class SSL3Mac implements Mac {
    public static final byte[] d;
    public static final byte[] e;
    public Digest a;
    public int b;
    public byte[] c;

    static {
        byte[] bArr = new byte[48];
        Arrays.fill(bArr, (byte) 54);
        d = bArr;
        byte[] bArr2 = new byte[48];
        Arrays.fill(bArr2, (byte) 92);
        e = bArr2;
    }

    public SSL3Mac(Digest digest) {
        this.a = digest;
        if (digest.getDigestSize() == 20) {
            this.b = 40;
        } else {
            this.b = 48;
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int digestSize = this.a.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.a.doFinal(bArr2, 0);
        Digest digest = this.a;
        byte[] bArr3 = this.c;
        digest.update(bArr3, 0, bArr3.length);
        this.a.update(e, 0, this.b);
        this.a.update(bArr2, 0, digestSize);
        int doFinal = this.a.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/SSL3MAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.a.getDigestSize();
    }

    public Digest getUnderlyingDigest() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        this.c = Arrays.clone(((KeyParameter) cipherParameters).getKey());
        reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.a.reset();
        Digest digest = this.a;
        byte[] bArr = this.c;
        digest.update(bArr, 0, bArr.length);
        this.a.update(d, 0, this.b);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
