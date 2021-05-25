package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;
import x6.e.b.d.a;
public class SP800SecureRandom extends SecureRandom {
    public final a a;
    public final boolean b;
    public final SecureRandom c;
    public final EntropySource d;
    public SP80090DRBG e;

    public SP800SecureRandom(SecureRandom secureRandom, EntropySource entropySource, a aVar, boolean z) {
        this.c = secureRandom;
        this.d = entropySource;
        this.a = aVar;
        this.b = z;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        return EntropyUtil.generateSeed(this.d, i);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.e == null) {
                this.e = this.a.a(this.d);
            }
            if (this.e.generate(bArr, null, this.b) < 0) {
                this.e.reseed(null);
                this.e.generate(bArr, null, this.b);
            }
        }
    }

    public void reseed(byte[] bArr) {
        synchronized (this) {
            if (this.e == null) {
                this.e = this.a.a(this.d);
            }
            this.e.reseed(bArr);
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.c;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j) {
        synchronized (this) {
            SecureRandom secureRandom = this.c;
            if (secureRandom != null) {
                secureRandom.setSeed(j);
            }
        }
    }
}
