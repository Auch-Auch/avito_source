package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Digest;
public class DigestRandomGenerator implements RandomGenerator {
    public long a;
    public long b = 1;
    public Digest c;
    public byte[] d;
    public byte[] e;

    public DigestRandomGenerator(Digest digest) {
        this.c = digest;
        this.e = new byte[digest.getDigestSize()];
        this.d = new byte[digest.getDigestSize()];
        this.a = 1;
    }

    public final void a(long j) {
        for (int i = 0; i != 8; i++) {
            this.c.update((byte) ((int) j));
            j >>>= 8;
        }
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            this.c.update(bArr, 0, bArr.length);
            c(this.e);
            b(this.e);
        }
    }

    public final void b(byte[] bArr) {
        this.c.doFinal(bArr, 0);
    }

    public final void c(byte[] bArr) {
        this.c.update(bArr, 0, bArr.length);
    }

    public final void d() {
        long j = this.a;
        this.a = j + 1;
        a(j);
        c(this.d);
        c(this.e);
        b(this.d);
        if (this.a % 10 == 0) {
            c(this.e);
            long j2 = this.b;
            this.b = 1 + j2;
            a(j2);
            b(this.e);
        }
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        synchronized (this) {
            d();
            int i3 = i2 + i;
            int i4 = 0;
            while (i != i3) {
                if (i4 == this.d.length) {
                    d();
                    i4 = 0;
                }
                bArr[i] = this.d[i4];
                i++;
                i4++;
            }
        }
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long j) {
        synchronized (this) {
            a(j);
            c(this.e);
            b(this.e);
        }
    }
}
