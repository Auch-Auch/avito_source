package org.spongycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    public BigInteger e;
    public int f;

    public RSAKeyGenerationParameters(BigInteger bigInteger, SecureRandom secureRandom, int i, int i2) {
        super(secureRandom, i);
        if (i < 12) {
            throw new IllegalArgumentException("key strength too small");
        } else if (bigInteger.testBit(0)) {
            this.e = bigInteger;
            this.f = i2;
        } else {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
    }

    public int getCertainty() {
        return this.f;
    }

    public BigInteger getPublicExponent() {
        return this.e;
    }
}
