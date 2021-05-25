package org.spongycastle.crypto.params;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
public class SM2KeyExchangePublicParameters implements CipherParameters {
    public ECPublicKeyParameters a;
    public ECPublicKeyParameters b;

    public SM2KeyExchangePublicParameters(ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2) {
        Objects.requireNonNull(eCPublicKeyParameters, "staticPublicKey cannot be null");
        Objects.requireNonNull(eCPublicKeyParameters2, "ephemeralPublicKey cannot be null");
        if (eCPublicKeyParameters.getParameters().equals(eCPublicKeyParameters2.getParameters())) {
            this.a = eCPublicKeyParameters;
            this.b = eCPublicKeyParameters2;
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.b;
    }

    public ECPublicKeyParameters getStaticPublicKey() {
        return this.a;
    }
}
