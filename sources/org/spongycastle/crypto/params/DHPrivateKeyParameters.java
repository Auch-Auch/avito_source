package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class DHPrivateKeyParameters extends DHKeyParameters {
    public BigInteger c;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.c = bigInteger;
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        if ((obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.c) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    public BigInteger getX() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.c.hashCode() ^ super.hashCode();
    }
}
