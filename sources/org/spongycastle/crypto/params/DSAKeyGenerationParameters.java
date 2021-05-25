package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class DSAKeyGenerationParameters extends KeyGenerationParameters {
    public DSAParameters e;

    public DSAKeyGenerationParameters(SecureRandom secureRandom, DSAParameters dSAParameters) {
        super(secureRandom, dSAParameters.getP().bitLength() - 1);
        this.e = dSAParameters;
    }

    public DSAParameters getParameters() {
        return this.e;
    }
}
