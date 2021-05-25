package org.spongycastle.jce.spec;

import org.spongycastle.math.ec.ECPoint;
public class ECPublicKeySpec extends ECKeySpec {
    public ECPoint b;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        if (eCPoint.getCurve() != null) {
            this.b = eCPoint.normalize();
        } else {
            this.b = eCPoint;
        }
    }

    public ECPoint getQ() {
        return this.b;
    }
}
