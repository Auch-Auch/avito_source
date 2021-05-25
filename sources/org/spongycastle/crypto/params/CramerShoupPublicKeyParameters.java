package org.spongycastle.crypto.params;

import java.math.BigInteger;
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {
    public BigInteger c;
    public BigInteger d;
    public BigInteger e;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.c = bigInteger;
        this.d = bigInteger2;
        this.e = bigInteger3;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        if (!cramerShoupPublicKeyParameters.getC().equals(this.c) || !cramerShoupPublicKeyParameters.getD().equals(this.d) || !cramerShoupPublicKeyParameters.getH().equals(this.e) || !super.equals(obj)) {
            return false;
        }
        return true;
    }

    public BigInteger getC() {
        return this.c;
    }

    public BigInteger getD() {
        return this.d;
    }

    public BigInteger getH() {
        return this.e;
    }

    @Override // org.spongycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return ((this.c.hashCode() ^ this.d.hashCode()) ^ this.e.hashCode()) ^ super.hashCode();
    }
}
