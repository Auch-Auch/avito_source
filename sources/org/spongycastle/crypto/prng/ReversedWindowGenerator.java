package org.spongycastle.crypto.prng;
public class ReversedWindowGenerator implements RandomGenerator {
    public final RandomGenerator a;
    public byte[] b;
    public int c;

    public ReversedWindowGenerator(RandomGenerator randomGenerator, int i) {
        if (randomGenerator == null) {
            throw new IllegalArgumentException("generator cannot be null");
        } else if (i >= 2) {
            this.a = randomGenerator;
            this.b = new byte[i];
        } else {
            throw new IllegalArgumentException("windowSize must be at least 2");
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.c < 1) {
                    RandomGenerator randomGenerator = this.a;
                    byte[] bArr2 = this.b;
                    randomGenerator.nextBytes(bArr2, 0, bArr2.length);
                    this.c = this.b.length;
                }
                byte[] bArr3 = this.b;
                int i4 = this.c - 1;
                this.c = i4;
                bArr[i3 + i] = bArr3[i4];
            }
        }
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            this.c = 0;
            this.a.addSeedMaterial(bArr);
        }
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        a(bArr, i, i2);
    }

    @Override // org.spongycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long j) {
        synchronized (this) {
            this.c = 0;
            this.a.addSeedMaterial(j);
        }
    }
}
