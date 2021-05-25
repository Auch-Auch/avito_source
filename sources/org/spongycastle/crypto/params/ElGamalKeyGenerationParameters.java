package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {
    public ElGamalParameters e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ElGamalKeyGenerationParameters(SecureRandom secureRandom, ElGamalParameters elGamalParameters) {
        super(secureRandom, elGamalParameters.getL() != 0 ? elGamalParameters.getL() : elGamalParameters.getP().bitLength());
        this.e = elGamalParameters;
    }

    public ElGamalParameters getParameters() {
        return this.e;
    }
}
