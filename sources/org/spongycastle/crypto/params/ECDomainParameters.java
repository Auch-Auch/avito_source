package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
public class ECDomainParameters implements ECConstants {
    public ECCurve a;
    public byte[] b;
    public ECPoint c;
    public BigInteger d;
    public BigInteger e;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ECConstants.ONE, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        if (!this.a.equals(eCDomainParameters.a) || !this.c.equals(eCDomainParameters.c) || !this.d.equals(eCDomainParameters.d) || !this.e.equals(eCDomainParameters.e)) {
            return false;
        }
        return true;
    }

    public ECCurve getCurve() {
        return this.a;
    }

    public ECPoint getG() {
        return this.c;
    }

    public BigInteger getH() {
        return this.e;
    }

    public BigInteger getN() {
        return this.d;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.b);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 37) ^ this.c.hashCode()) * 37) ^ this.d.hashCode()) * 37) ^ this.e.hashCode();
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = eCCurve;
        this.c = eCPoint.normalize();
        this.d = bigInteger;
        this.e = bigInteger2;
        this.b = bArr;
    }
}
