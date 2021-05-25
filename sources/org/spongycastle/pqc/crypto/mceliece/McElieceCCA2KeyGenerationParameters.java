package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class McElieceCCA2KeyGenerationParameters extends KeyGenerationParameters {
    public McElieceCCA2Parameters e;

    public McElieceCCA2KeyGenerationParameters(SecureRandom secureRandom, McElieceCCA2Parameters mcElieceCCA2Parameters) {
        super(secureRandom, 128);
        this.e = mcElieceCCA2Parameters;
    }

    public McElieceCCA2Parameters getParameters() {
        return this.e;
    }
}
