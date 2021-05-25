package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {
    public BigInteger c;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.c = bigInteger;
    }

    @Override // org.spongycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.c) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    public BigInteger getY() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        return this.c.hashCode() ^ super.hashCode();
    }
}
