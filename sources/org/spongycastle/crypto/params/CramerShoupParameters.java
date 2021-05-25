package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
public class CramerShoupParameters implements CipherParameters {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public Digest d;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
        this.d = digest;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        if (!cramerShoupParameters.getP().equals(this.a) || !cramerShoupParameters.getG1().equals(this.b) || !cramerShoupParameters.getG2().equals(this.c)) {
            return false;
        }
        return true;
    }

    public BigInteger getG1() {
        return this.b;
    }

    public BigInteger getG2() {
        return this.c;
    }

    public Digest getH() {
        this.d.reset();
        return this.d;
    }

    public BigInteger getP() {
        return this.a;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}
