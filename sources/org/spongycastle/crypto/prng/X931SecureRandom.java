package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
public class X931SecureRandom extends SecureRandom {
    public final boolean a;
    public final SecureRandom b;
    public final X931RNG c;

    public X931SecureRandom(SecureRandom secureRandom, X931RNG x931rng, boolean z) {
        this.b = secureRandom;
        this.c = x931rng;
        this.a = z;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        return EntropyUtil.generateSeed(this.c.b, i);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.c.a(bArr, this.a) < 0) {
                X931RNG x931rng = this.c;
                byte[] entropy = x931rng.b.getEntropy();
                x931rng.f = entropy;
                if (entropy.length == x931rng.a.getBlockSize()) {
                    x931rng.g = 1;
                    this.c.a(bArr, this.a);
                } else {
                    throw new IllegalStateException("Insufficient entropy returned");
                }
            }
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.b;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j) {
        synchronized (this) {
            SecureRandom secureRandom = this.b;
            if (secureRandom != null) {
                secureRandom.setSeed(j);
            }
        }
    }
}
