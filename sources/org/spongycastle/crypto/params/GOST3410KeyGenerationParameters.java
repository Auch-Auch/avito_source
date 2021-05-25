package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class GOST3410KeyGenerationParameters extends KeyGenerationParameters {
    public GOST3410Parameters e;

    public GOST3410KeyGenerationParameters(SecureRandom secureRandom, GOST3410Parameters gOST3410Parameters) {
        super(secureRandom, gOST3410Parameters.getP().bitLength() - 1);
        this.e = gOST3410Parameters;
    }

    public GOST3410Parameters getParameters() {
        return this.e;
    }
}
