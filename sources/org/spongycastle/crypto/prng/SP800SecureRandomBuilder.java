package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HashSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;
public class SP800SecureRandomBuilder {
    public final SecureRandom a;
    public final EntropySourceProvider b;
    public byte[] c;
    public int d;
    public int e;

    public static class a implements x6.e.b.d.a {
        public final BlockCipher a;
        public final int b;
        public final byte[] c;
        public final byte[] d;
        public final int e;

        public a(BlockCipher blockCipher, int i, byte[] bArr, byte[] bArr2, int i2) {
            this.a = blockCipher;
            this.b = i;
            this.c = bArr;
            this.d = bArr2;
            this.e = i2;
        }

        @Override // x6.e.b.d.a
        public SP80090DRBG a(EntropySource entropySource) {
            return new CTRSP800DRBG(this.a, this.b, this.e, entropySource, this.d, this.c);
        }
    }

    public static class b implements x6.e.b.d.a {
        public final Mac a;
        public final byte[] b;
        public final byte[] c;
        public final int d;

        public b(Mac mac, byte[] bArr, byte[] bArr2, int i) {
            this.a = mac;
            this.b = bArr;
            this.c = bArr2;
            this.d = i;
        }

        @Override // x6.e.b.d.a
        public SP80090DRBG a(EntropySource entropySource) {
            return new HMacSP800DRBG(this.a, this.d, entropySource, this.c, this.b);
        }
    }

    public static class c implements x6.e.b.d.a {
        public final Digest a;
        public final byte[] b;
        public final byte[] c;
        public final int d;

        public c(Digest digest, byte[] bArr, byte[] bArr2, int i) {
            this.a = digest;
            this.b = bArr;
            this.c = bArr2;
            this.d = i;
        }

        @Override // x6.e.b.d.a
        public SP80090DRBG a(EntropySource entropySource) {
            return new HashSP800DRBG(this.a, this.d, entropySource, this.c, this.b);
        }
    }

    public SP800SecureRandomBuilder() {
        this(new SecureRandom(), false);
    }

    public SP800SecureRandom buildCTR(BlockCipher blockCipher, int i, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.a, this.b.get(this.e), new a(blockCipher, i, bArr, this.c, this.d), z);
    }

    public SP800SecureRandom buildHMAC(Mac mac, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.a, this.b.get(this.e), new b(mac, bArr, this.c, this.d), z);
    }

    public SP800SecureRandom buildHash(Digest digest, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.a, this.b.get(this.e), new c(digest, bArr, this.c, this.d), z);
    }

    public SP800SecureRandomBuilder setEntropyBitsRequired(int i) {
        this.e = i;
        return this;
    }

    public SP800SecureRandomBuilder setPersonalizationString(byte[] bArr) {
        this.c = bArr;
        return this;
    }

    public SP800SecureRandomBuilder setSecurityStrength(int i) {
        this.d = i;
        return this;
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.d = 256;
        this.e = 256;
        this.a = secureRandom;
        this.b = new BasicEntropySourceProvider(secureRandom, z);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider entropySourceProvider) {
        this.d = 256;
        this.e = 256;
        this.a = null;
        this.b = entropySourceProvider;
    }
}
