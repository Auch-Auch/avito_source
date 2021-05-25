package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
public class ElGamalParameters implements CipherParameters {
    public BigInteger a;
    public BigInteger b;
    public int c;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (!elGamalParameters.getP().equals(this.b) || !elGamalParameters.getG().equals(this.a) || elGamalParameters.getL() != this.c) {
            return false;
        }
        return true;
    }

    public BigInteger getG() {
        return this.a;
    }

    public int getL() {
        return this.c;
    }

    public BigInteger getP() {
        return this.b;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.c;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.a = bigInteger2;
        this.b = bigInteger;
        this.c = i;
    }
}
