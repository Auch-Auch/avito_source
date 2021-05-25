package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class NaccacheSternKeyGenerationParameters extends KeyGenerationParameters {
    public int e;
    public int f;
    public boolean g;

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i, int i2, int i3) {
        this(secureRandom, i, i2, i3, false);
    }

    public int getCertainty() {
        return this.e;
    }

    public int getCntSmallPrimes() {
        return this.f;
    }

    public boolean isDebug() {
        return this.g;
    }

    public NaccacheSternKeyGenerationParameters(SecureRandom secureRandom, int i, int i2, int i3, boolean z) {
        super(secureRandom, i);
        this.g = false;
        this.e = i2;
        if (i3 % 2 == 1) {
            throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
        } else if (i3 >= 30) {
            this.f = i3;
            this.g = z;
        } else {
            throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
        }
    }
}
