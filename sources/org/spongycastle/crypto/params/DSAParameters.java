package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
public class DSAParameters implements CipherParameters {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public DSAValidationParameters d;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (!dSAParameters.getP().equals(this.c) || !dSAParameters.getQ().equals(this.b) || !dSAParameters.getG().equals(this.a)) {
            return false;
        }
        return true;
    }

    public BigInteger getG() {
        return this.a;
    }

    public BigInteger getP() {
        return this.c;
    }

    public BigInteger getQ() {
        return this.b;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.d;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
        this.d = dSAValidationParameters;
    }
}
