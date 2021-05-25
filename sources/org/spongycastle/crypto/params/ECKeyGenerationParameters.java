package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class ECKeyGenerationParameters extends KeyGenerationParameters {
    public ECDomainParameters e;

    public ECKeyGenerationParameters(ECDomainParameters eCDomainParameters, SecureRandom secureRandom) {
        super(secureRandom, eCDomainParameters.getN().bitLength());
        this.e = eCDomainParameters;
    }

    public ECDomainParameters getDomainParameters() {
        return this.e;
    }
}
