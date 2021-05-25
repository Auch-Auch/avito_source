package org.spongycastle.pqc.crypto.gmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class GMSSKeyGenerationParameters extends KeyGenerationParameters {
    public GMSSParameters e;

    public GMSSKeyGenerationParameters(SecureRandom secureRandom, GMSSParameters gMSSParameters) {
        super(secureRandom, 1);
        this.e = gMSSParameters;
    }

    public GMSSParameters getParameters() {
        return this.e;
    }
}
