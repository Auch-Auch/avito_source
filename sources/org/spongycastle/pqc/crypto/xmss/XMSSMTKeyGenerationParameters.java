package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public final class XMSSMTKeyGenerationParameters extends KeyGenerationParameters {
    public final XMSSMTParameters e;

    public XMSSMTKeyGenerationParameters(XMSSMTParameters xMSSMTParameters, SecureRandom secureRandom) {
        super(secureRandom, -1);
        this.e = xMSSMTParameters;
    }

    public XMSSMTParameters getParameters() {
        return this.e;
    }
}
