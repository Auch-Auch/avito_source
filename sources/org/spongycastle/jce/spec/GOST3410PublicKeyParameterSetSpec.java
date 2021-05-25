package org.spongycastle.jce.spec;

import java.math.BigInteger;
public class GOST3410PublicKeyParameterSetSpec {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        if (!this.c.equals(gOST3410PublicKeyParameterSetSpec.c) || !this.a.equals(gOST3410PublicKeyParameterSetSpec.a) || !this.b.equals(gOST3410PublicKeyParameterSetSpec.b)) {
            return false;
        }
        return true;
    }

    public BigInteger getA() {
        return this.c;
    }

    public BigInteger getP() {
        return this.a;
    }

    public BigInteger getQ() {
        return this.b;
    }

    public int hashCode() {
        return (this.c.hashCode() ^ this.a.hashCode()) ^ this.b.hashCode();
    }
}
