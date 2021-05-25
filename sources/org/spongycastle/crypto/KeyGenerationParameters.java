package org.spongycastle.crypto;

import java.security.SecureRandom;
public class KeyGenerationParameters {
    public SecureRandom a;
    public int b;

    public KeyGenerationParameters(SecureRandom secureRandom, int i) {
        this.a = secureRandom;
        this.b = i;
    }

    public SecureRandom getRandom() {
        return this.a;
    }

    public int getStrength() {
        return this.b;
    }
}
