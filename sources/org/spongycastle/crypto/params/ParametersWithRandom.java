package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
public class ParametersWithRandom implements CipherParameters {
    public SecureRandom a;
    public CipherParameters b;

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.a = secureRandom;
        this.b = cipherParameters;
    }

    public CipherParameters getParameters() {
        return this.b;
    }

    public SecureRandom getRandom() {
        return this.a;
    }

    public ParametersWithRandom(CipherParameters cipherParameters) {
        this(cipherParameters, new SecureRandom());
    }
}
