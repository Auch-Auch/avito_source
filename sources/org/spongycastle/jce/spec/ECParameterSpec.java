package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
public class ECParameterSpec implements AlgorithmParameterSpec {
    public ECCurve a;
    public byte[] b;
    public ECPoint c;
    public BigInteger d;
    public BigInteger e;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.a = eCCurve;
        this.c = eCPoint.normalize();
        this.d = bigInteger;
        this.e = BigInteger.valueOf(1);
        this.b = null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        if (!getCurve().equals(eCParameterSpec.getCurve()) || !getG().equals(eCParameterSpec.getG())) {
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
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = eCCurve;
        this.c = eCPoint.normalize();
        this.d = bigInteger;
        this.e = bigInteger2;
        this.b = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = eCCurve;
        this.c = eCPoint.normalize();
        this.d = bigInteger;
        this.e = bigInteger2;
        this.b = bArr;
    }
}
