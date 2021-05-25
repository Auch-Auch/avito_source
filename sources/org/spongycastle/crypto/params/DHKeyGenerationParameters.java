package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class DHKeyGenerationParameters extends KeyGenerationParameters {
    public DHParameters e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DHKeyGenerationParameters(SecureRandom secureRandom, DHParameters dHParameters) {
        super(secureRandom, dHParameters.getL() != 0 ? dHParameters.getL() : dHParameters.getP().bitLength());
        this.e = dHParameters;
    }

    public DHParameters getParameters() {
        return this.e;
    }
}
