package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
public class RSABlindingParameters implements CipherParameters {
    public RSAKeyParameters a;
    public BigInteger b;

    public RSABlindingParameters(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger) {
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters)) {
            this.a = rSAKeyParameters;
            this.b = bigInteger;
            return;
        }
        throw new IllegalArgumentException("RSA parameters should be for a public key");
    }

    public BigInteger getBlindingFactor() {
        return this.b;
    }

    public RSAKeyParameters getPublicKey() {
        return this.a;
    }
}
