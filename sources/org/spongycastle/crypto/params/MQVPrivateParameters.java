package org.spongycastle.crypto.params;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
public class MQVPrivateParameters implements CipherParameters {
    public ECPrivateKeyParameters a;
    public ECPrivateKeyParameters b;
    public ECPublicKeyParameters c;

    public MQVPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2) {
        this(eCPrivateKeyParameters, eCPrivateKeyParameters2, null);
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.b;
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.c;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.a;
    }

    public MQVPrivateParameters(ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters) {
        Objects.requireNonNull(eCPrivateKeyParameters, "staticPrivateKey cannot be null");
        Objects.requireNonNull(eCPrivateKeyParameters2, "ephemeralPrivateKey cannot be null");
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        if (parameters.equals(eCPrivateKeyParameters2.getParameters())) {
            if (eCPublicKeyParameters == null) {
                eCPublicKeyParameters = new ECPublicKeyParameters(parameters.getG().multiply(eCPrivateKeyParameters2.getD()), parameters);
            } else if (!parameters.equals(eCPublicKeyParameters.getParameters())) {
                throw new IllegalArgumentException("Ephemeral public key has different domain parameters");
            }
            this.a = eCPrivateKeyParameters;
            this.b = eCPrivateKeyParameters2;
            this.c = eCPublicKeyParameters;
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
    }
}
