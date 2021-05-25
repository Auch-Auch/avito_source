package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {
    public BigInteger c;
    public BigInteger d;
    public BigInteger e;
    public BigInteger f;
    public BigInteger g;
    public CramerShoupPublicKeyParameters i;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.c = bigInteger;
        this.d = bigInteger2;
        this.e = bigInteger3;
        this.f = bigInteger4;
        this.g = bigInteger5;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        if (!cramerShoupPrivateKeyParameters.getX1().equals(this.c) || !cramerShoupPrivateKeyParameters.getX2().equals(this.d) || !cramerShoupPrivateKeyParameters.getY1().equals(this.e) || !cramerShoupPrivateKeyParameters.getY2().equals(this.f) || !cramerShoupPrivateKeyParameters.getZ().equals(this.g) || !super.equals(obj)) {
            return false;
        }
        return true;
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.i;
    }

    public BigInteger getX1() {
        return this.c;
    }

    public BigInteger getX2() {
        return this.d;
    }

    public BigInteger getY1() {
        return this.e;
    }

    public BigInteger getY2() {
        return this.f;
    }

    public BigInteger getZ() {
        return this.g;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((((this.c.hashCode() ^ this.d.hashCode()) ^ this.e.hashCode()) ^ this.f.hashCode()) ^ this.g.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.i = cramerShoupPublicKeyParameters;
    }
}
