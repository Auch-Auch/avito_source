package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;
public class McElieceKeyGenerationParameters extends KeyGenerationParameters {
    public McElieceParameters e;

    public McElieceKeyGenerationParameters(SecureRandom secureRandom, McElieceParameters mcElieceParameters) {
        super(secureRandom, 256);
        this.e = mcElieceParameters;
    }

    public McElieceParameters getParameters() {
        return this.e;
    }
}
