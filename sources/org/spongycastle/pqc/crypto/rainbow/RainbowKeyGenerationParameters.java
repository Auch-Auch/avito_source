package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class RainbowKeyGenerationParameters extends KeyGenerationParameters {
    public RainbowParameters e;

    public RainbowKeyGenerationParameters(SecureRandom secureRandom, RainbowParameters rainbowParameters) {
        super(secureRandom, rainbowParameters.getVi()[rainbowParameters.getVi().length - 1] - rainbowParameters.getVi()[0]);
        this.e = rainbowParameters;
    }

    public RainbowParameters getParameters() {
        return this.e;
    }
}
