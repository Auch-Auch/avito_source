package org.spongycastle.crypto.params;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.math.ec.ECPoint;
public class SM2KeyExchangePrivateParameters implements CipherParameters {
    public final boolean a;
    public final ECPrivateKeyParameters b;
    public final ECPoint c;
    public final ECPrivateKeyParameters d;
    public final ECPoint e;

    public SM2KeyExchangePrivateParameters(boolean z, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2) {
        Objects.requireNonNull(eCPrivateKeyParameters, "staticPrivateKey cannot be null");
        Objects.requireNonNull(eCPrivateKeyParameters2, "ephemeralPrivateKey cannot be null");
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        if (parameters.equals(eCPrivateKeyParameters2.getParameters())) {
            this.a = z;
            this.b = eCPrivateKeyParameters;
            this.c = parameters.getG().multiply(eCPrivateKeyParameters.getD()).normalize();
            this.d = eCPrivateKeyParameters2;
            this.e = parameters.getG().multiply(eCPrivateKeyParameters2.getD()).normalize();
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.d;
    }

    public ECPoint getEphemeralPublicPoint() {
        return this.e;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.b;
    }

    public ECPoint getStaticPublicPoint() {
        return this.c;
    }

    public boolean isInitiator() {
        return this.a;
    }
}
