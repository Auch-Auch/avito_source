package org.spongycastle.jce.spec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
public class ECNamedCurveParameterSpec extends ECParameterSpec {
    public String f;

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(eCCurve, eCPoint, bigInteger);
        this.f = str;
    }

    public String getName() {
        return this.f;
    }

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2);
        this.f = str;
    }

    public ECNamedCurveParameterSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(eCCurve, eCPoint, bigInteger, bigInteger2, bArr);
        this.f = str;
    }
}
