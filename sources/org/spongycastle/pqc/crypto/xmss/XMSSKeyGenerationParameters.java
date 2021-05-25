package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public final class XMSSKeyGenerationParameters extends KeyGenerationParameters {
    public final XMSSParameters e;

    public XMSSKeyGenerationParameters(XMSSParameters xMSSParameters, SecureRandom secureRandom) {
        super(secureRandom, -1);
        this.e = xMSSParameters;
    }

    public XMSSParameters getParameters() {
        return this.e;
    }
}
