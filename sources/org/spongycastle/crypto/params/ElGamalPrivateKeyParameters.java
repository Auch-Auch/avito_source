package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {
    public BigInteger c;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.c = bigInteger;
    }

    @Override // org.spongycastle.crypto.params.ElGamalKeyParameters
    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).getX().equals(this.c)) {
            return super.equals(obj);
        }
        return false;
    }

    public BigInteger getX() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.params.ElGamalKeyParameters
    public int hashCode() {
        return getX().hashCode();
    }
}
