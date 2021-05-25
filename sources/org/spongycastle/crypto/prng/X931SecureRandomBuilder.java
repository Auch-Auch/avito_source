package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;
public class X931SecureRandomBuilder {
    public SecureRandom a;
    public EntropySourceProvider b;
    public byte[] c;

    public X931SecureRandomBuilder() {
        this(new SecureRandom(), false);
    }

    public X931SecureRandom build(BlockCipher blockCipher, KeyParameter keyParameter, boolean z) {
        if (this.c == null) {
            this.c = new byte[blockCipher.getBlockSize()];
            Pack.longToBigEndian(System.currentTimeMillis(), this.c, 0);
        }
        blockCipher.init(true, keyParameter);
        return new X931SecureRandom(this.a, new X931RNG(blockCipher, this.c, this.b.get(blockCipher.getBlockSize() * 8)), z);
    }

    public X931SecureRandomBuilder setDateTimeVector(byte[] bArr) {
        this.c = bArr;
        return this;
    }

    public X931SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.a = secureRandom;
        this.b = new BasicEntropySourceProvider(secureRandom, z);
    }

    public X931SecureRandomBuilder(EntropySourceProvider entropySourceProvider) {
        this.a = null;
        this.b = entropySourceProvider;
    }
}
