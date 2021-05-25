package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class CramerShoupKeyGenerationParameters extends KeyGenerationParameters {
    public CramerShoupParameters e;

    public CramerShoupKeyGenerationParameters(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        super(secureRandom, cramerShoupParameters.getP().bitLength());
        this.e = cramerShoupParameters;
    }

    public CramerShoupParameters getParameters() {
        return this.e;
    }
}
